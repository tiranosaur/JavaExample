package org.example.demors.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

@Path("/")
public class MainResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        Map<String, String> map = new HashMap<>();
        map.put("status", "true");
        map.put("message", "OK");
        return Response.ok(map).build();
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Response.ok("Hello Tiranosaur!!!").build();
    }

    @GET
    @Path("/err")
    @Produces(MediaType.TEXT_PLAIN)
    public Response error() {
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
    }
}
