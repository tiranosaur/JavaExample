package org.example.flux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {
    private String message;

    @Override
    public String toString() {
        return "Greeting{" + "message='" + message + '\'' + '}';
    }
}