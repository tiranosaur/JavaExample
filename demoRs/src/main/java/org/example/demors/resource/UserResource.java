package org.example.demors.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.demors.dao.UserDAO;
import org.example.demors.model.User;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Path("/user")
public class UserResource {
    private final UserDAO userDAO;

    @Inject
    public UserResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GET
    @Path("/error")
    @Produces(MediaType.APPLICATION_JSON)
    public Response error() {
        userDAO.getError();
        return Response.ok().build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("limit") @DefaultValue("10") int limit
    ) {
        CompletableFuture<List<User>> result = CompletableFuture.supplyAsync(() -> userDAO.getUsers(page, limit));
        return Response.ok().entity(result).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(
            @PathParam("id") int id
    ) {
        CompletableFuture<User> result = CompletableFuture.supplyAsync(() -> userDAO.getUser(id));
        return Response.ok().entity(result).build();
    }
}
