package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.util.UriUtil;
import org.example.util.UserUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UserController implements Controller {
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final List<User> userList = new ArrayList<>();
    private static final UserRepository userRepository = new UserRepository();

    static {
        User user = new User();
        user.setId(UUID.fromString("14d231f3-4fa5-4922-b52b-c13d96ed8abd"));
        user.setName("John");
        user.setAge(42);
        userList.add(user);
    }

    @Override
    public boolean isSupported(HttpExchange exchange) {
        return exchange.getRequestURI().getPath().startsWith("/user");
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        switch (exchange.getRequestMethod()) {
            case "GET":
                this.get(exchange);
                break;
            case "POST":
                this.post(exchange);
                break;
            case "PUT":
                this.put(exchange);
                break;
            case "DELETE":
                this.delete(exchange);
                break;
            default:
                Controller.throwNotFound(exchange);
        }
    }

    private void get(HttpExchange exchange) throws IOException {
        Map<String, Object> paramMap = UriUtil.getQueryParamMap(exchange);
        String json = "";
        if (paramMap.containsKey("id")) {
            try {
                UUID id = UUID.fromString(paramMap.get("id").toString());
                User user = userRepository.get(id);
                if (user != null) {
                    json = objectMapper.writeValueAsString(user);
                }
            } catch (Exception e) {
                Controller.throwNotFound(exchange);
            }
        } else {
            json = objectMapper.writeValueAsString(userRepository.getAll());
        }

        exchange.sendResponseHeaders(200, json.length());
        OutputStream os = exchange.getResponseBody();
        os.write(json.getBytes());
        os.close();
    }

    private void post(HttpExchange exchange) throws IOException {
        byte[] bodyBytes = exchange.getRequestBody().readAllBytes();
        String body = new String(bodyBytes, StandardCharsets.UTF_8);

        User user = objectMapper.readValue(body, User.class);

        Map<String, String> errors = UserUtil.validate(user);
        if (!errors.isEmpty()) {
            String errorJson = objectMapper.writeValueAsString(errors);
            Controller.sendCustom(exchange, 400, errorJson);
        }

        user.setId(UUID.randomUUID());
        userRepository.save(user);
        Controller.sendSuccess(exchange);
    }

    private void put(HttpExchange exchange) throws IOException {
        Map<String, Object> paramMap = UriUtil.getQueryParamMap(exchange);
        UUID id = UriUtil.getUUID(paramMap.get("id"));
        if (id == null) {
            Controller.throwNotFound(exchange);
            return;
        }

        User userOld = userList.stream().filter(x -> id.equals(x.getId())).findFirst().orElse(null);
        if (userOld == null) {
            Controller.throwNotFound(exchange);
            return;
        }

        byte[] bodyBytes = exchange.getRequestBody().readAllBytes();
        String body = new String(bodyBytes, StandardCharsets.UTF_8);
        User user = objectMapper.readValue(body, User.class);

        Map<String, String> errors = UserUtil.validate(user);
        if (!errors.isEmpty()) {
            String errorJson = objectMapper.writeValueAsString(errors);
            Controller.sendCustom(exchange, 400, errorJson);
            return;
        }

        userOld.setName(user.getName());
        userOld.setAge(user.getAge());

        Controller.sendSuccess(exchange);
    }

    private void delete(HttpExchange exchange) throws IOException {
        Map<String, Object> paramMap = UriUtil.getQueryParamMap(exchange);
        UUID id = UriUtil.getUUID(paramMap.get("id"));
        if (id == null) {
            Controller.throwNotFound(exchange);
            return;
        }

        User user = userRepository.get(id);
        if (user == null) {
            Controller.throwNotFound(exchange);
            return;
        }

       userRepository.delete(id);
        Controller.sendSuccess(exchange);
    }
}
