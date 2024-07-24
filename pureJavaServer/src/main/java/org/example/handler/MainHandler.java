package org.example.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.controller.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;

public class MainHandler implements HttpHandler {
    private static final List<Controller> controllerList = new ArrayList<>();

    static {
        ServiceLoader<Controller> loader = ServiceLoader.load(Controller.class);
        for (Controller controller : loader) {
            controllerList.add(controller);
        }
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Optional<Controller> optionalController = controllerList.stream()
                .filter(x -> x.isSupported(exchange))
                .findFirst();

        if (optionalController.isPresent()) {
            Controller controller = optionalController.get();
            controller.handle(exchange);
        } else {
            Controller.throwNotFound(exchange);
        }
    }
}
