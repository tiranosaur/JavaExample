package com.example.springdemo.gRPC_client;

import com.example.springdemo.Hello;
import com.example.springdemo.HelloServiceGrpc;
import com.example.springdemo.User;
import com.example.springdemo.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub helloStub = HelloServiceGrpc.newBlockingStub(channel);

        Hello.HelloResponse helloResponse = helloStub.hello(Hello.HelloRequest.newBuilder()
                .setFirstName("Baeldung")
                .setLastName("gRPC")
                .build());

        System.out.println("Response received from server:\n" + helloResponse);


        UserServiceGrpc.UserServiceBlockingStub userStub = UserServiceGrpc.newBlockingStub(channel);
        User.UserResponse userResponse = userStub.get(User.UserRequest.newBuilder().setId("sdlfkj").build());
        System.out.println(userResponse.getId());
        System.out.println(userResponse.getName());
        System.out.println(userResponse.getAge());

        channel.shutdown();
    }
}