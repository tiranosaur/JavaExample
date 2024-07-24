package org.example.controller;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public interface Controller {
    boolean isSupported(HttpExchange exchange);

    void handle(HttpExchange exchange) throws IOException;

    static void sendCustom(HttpExchange exchange, int code, String message) throws IOException {
        exchange.sendResponseHeaders(code, message.length());
        OutputStream os = exchange.getResponseBody();
        os.write(message.getBytes());
        os.close();
    }

    static void sendSuccess(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, 0);
        OutputStream os = exchange.getResponseBody();
        os.close();
    }

    static void throwNotFound(HttpExchange exchange) throws IOException {
        String notFoundString = "{'code': 404,'status':false,'message': 'Not Found'}";
        exchange.sendResponseHeaders(404, notFoundString.length());
        OutputStream os = exchange.getResponseBody();
        os.write(notFoundString.getBytes());
        os.close();
    }
}
