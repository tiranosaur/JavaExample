package org.example.demors.handler;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.HashMap;
import java.util.Map;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "false");
        map.put("message", e.getMessage());
        return Response
                .status(503)
                .entity(map)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
