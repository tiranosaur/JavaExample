package org.example.demors.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.demors.model.User;

import java.util.concurrent.Future;

@Path("/client")
public class UserClientResource {
    @GET
    @Path("/response")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse() {
        try (Client client = ClientBuilder.newClient()) {
            Response response = client.target("http://localhost:8080/demoRs_war_exploded/api/user/22")
                    .request(MediaType.APPLICATION_JSON)
                    .get();

            if (response.getStatus() != 200) {
                return Response.status(response.getStatus()).build();
            }
            return response;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser() {
        try (Client client = ClientBuilder.newClient()) {
            User user = client.target("http://localhost:8080/demoRs_war_exploded/api/user/22")
                    .request(MediaType.APPLICATION_JSON)
                    .get(User.class);
            return Response.ok(user).build();
        }
    }

    @GET
    @Path("/async")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserAsync() {
        try (Client client = ClientBuilder.newClient()) {
            Future<User> userFuture = client.target("http://localhost:8080/demoRs_war_exploded/api/user/22")
                    .request(MediaType.APPLICATION_JSON)
                    .async()
                    .get(User.class);
            return Response.ok(userFuture).build();
        }
    }
}
