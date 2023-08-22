package com.example.springdemo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.StringReader;

public class JsonPreparer<V> {
    public static <T> T prepare(String fileName, TypeReference<T> typeReference) {
        try {
            File file = ResourceUtils.getFile("classpath:" + fileName);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());

            return objectMapper.readValue(file, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T convert(String json, TypeReference<T> typeReference) {
        try {
            StringReader reader = new StringReader(json);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());

            return objectMapper.readValue(reader, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> String toString(T t) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            return mapper.writeValueAsString(t);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}