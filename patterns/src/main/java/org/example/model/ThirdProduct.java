package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThirdProduct implements Product {
    private String name;

    public void printName() {
        System.out.println(name);
    }

    public void printClassName() {
        System.out.println(this.getClass().getSimpleName());
    }

    public void startProcess() {
        System.out.println(getName() + " is starting process");
    }

    public void endProcess() {
        System.out.println(getName() + " is ending process");
    }
}
