package org.example.demors.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.demors.service.MainService;

import java.util.Map;

@Path("/")
public class MainResource {
    private final MainService mainService;

    @Inject
    public MainResource(MainService mainService) {
        this.mainService = mainService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        Map<String, Object> resp = mainService.getOkStatusMap();
        return Response.ok(resp).build();
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
