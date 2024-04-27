package org.example.gof.creational;

import lombok.Getter;
import lombok.Setter;

public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        ClassicPrototype classicPrototype = new ClassicPrototype();
        classicPrototype.setName("Classic Prototype");

        ClassicPrototype cloned = classicPrototype.clone();
        System.out.println(cloned.getName());
    }
}

@Getter
@Setter
class ClassicPrototype implements Cloneable {
    private String name;

    @Override
    public ClassicPrototype clone() throws CloneNotSupportedException {
        return (ClassicPrototype) super.clone();
    }
}
