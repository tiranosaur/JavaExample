package com.example.springdemo.data;

import com.fasterxml.jackson.databind.JsonSerializable;
import lombok.Data;

import java.io.Serializable;

@Data
public class TestDTO {
    private Integer id;
    private String message;
}