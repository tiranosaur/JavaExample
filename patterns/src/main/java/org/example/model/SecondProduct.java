package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SecondProduct implements Product {
    private String name;

    public void printName() {
        System.out.println(this.getClass().getSimpleName());
    }
}
