package org.example;

import com.sun.net.httpserver.*;
import org.example.handler.MainHandler;

import java.net.*;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new MainHandler());
        server.start();
        System.out.println("Server started on port 8080");
    }
}