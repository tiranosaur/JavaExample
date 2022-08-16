package com.example.springdemo.gRPC_server;

import com.example.springdemo.User;
import com.example.springdemo.UserServiceGrpc;
import io.grpc.stub.StreamObserver;

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {


    @Override
    public void get(User.UserRequest request, StreamObserver<User.UserResponse> responseObserver) {
        System.out.println("Request received from client:\n" + request);

        User.UserResponse response = User.UserResponse.newBuilder()
                .setId(3456345L)
                .setName("John")
                .setAge(33)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
