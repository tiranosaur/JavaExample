package org.example.gof.creational;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Constructor;

// Простая фабрика генерирует экземпляр для клиента, не раскрывая никакой логики.
public class SimpleFactory {
    public static void main(String[] args) {
        ClassicSimpleFactory classicSimpleFactory = new ClassicSimpleFactory();
        MyClass myFirstClass = classicSimpleFactory.create(ClassicSimpleFactory.Type.FirstClass);
        myFirstClass.setName("First Class");
        System.out.println(myFirstClass.getName());

        MySimpleFacctory mySimpleFacctory = new MySimpleFacctory();
        MyClass mySecondClass = mySimpleFacctory.create(MySecondClass.class);
        mySecondClass.setName("Second Class");
        System.out.println(mySecondClass.getName());

        MyClass myClass = StaticSimpleFacctory.create(MySecondClass.class);
        myClass.setName("static creator");
        System.out.println(myClass.getName());
    }
}

class ClassicSimpleFactory {
    public enum Type {
        FirstClass, SecondClass
    }

    public MyClass create(Type type) {
        switch (type) {
            case FirstClass:
                return new MyFirstClass();
            case SecondClass:
                return new MySecondClass();
            default:
                return null;
        }
    }
}

class MySimpleFacctory {
    public <T extends MyClass> MyClass create(Class<T> tClass) {
        try {
            Constructor<T> constructor = tClass.getConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class StaticSimpleFacctory {
    private StaticSimpleFacctory() {
    }

    public static <T extends MyClass> MyClass create(Class<T> tClass) {
        try {
            Constructor<T> constructor = tClass.getConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

interface MyClass {
    String getName();

    void setName(String name);
}

@Getter
@Setter
@NoArgsConstructor
class MyFirstClass implements MyClass {
    private String name;
}

@Getter
@Setter
@NoArgsConstructor
class MySecondClass implements MyClass {
    private String name;
}