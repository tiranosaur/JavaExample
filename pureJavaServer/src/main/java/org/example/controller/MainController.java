package org.example.controller;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class MainController implements Controller {
    @Override
    public boolean isSupported(HttpExchange exchange) {
        String path = exchange.getRequestURI().getPath();
        return path.equals("/");
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        switch (exchange.getRequestMethod()) {
            case "GET":
                this.SendHello(exchange);
                break;
            case "POST":
            case "PUT":
            case "DELETE":
            default:
                Controller.throwNotFound(exchange);
        }
    }

    private void SendHello(HttpExchange exchange) throws IOException {
        String responseString = "Hello World! from MainController";
        exchange.sendResponseHeaders(200, responseString.length());
        OutputStream os = exchange.getResponseBody();
        os.write(responseString.getBytes());
        os.close();
    }
}
