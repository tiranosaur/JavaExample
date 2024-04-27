package org.example.gof.creational;

// Фабрика фабрик. Фабрика, которая группирует индивидуальные, но связанные/зависимые фабрики без указания их конкретных классов.
public class AbstractFactory {
    public static void main(String[] args) {
        ClassicAbstractFactory factory1 = new ConcreteFactory1();
        ProductA productA1 = factory1.createProductA();
        productA1.operationA();
        ProductB productB1 = factory1.createProductB();
        productB1.operationB();

        ClassicAbstractFactory factory2 = new ConcreteFactory2();
        ProductA productA2 = factory2.createProductA();
        productA2.operationA();
        ProductB productB2 = factory2.createProductB();
        productB2.operationB();
    }
}

interface ProductA {
    void operationA();
}

class ConcreteProductA1 implements ProductA {
    public String creator;

    public ConcreteProductA1(String creator) {
        this.creator = creator;
    }

    @Override
    public void operationA() {
        System.out.println("Operation A from ConcreteProductA1 - " + creator);
    }
}

class ConcreteProductA2 implements ProductA {
    public String creator;

    public ConcreteProductA2(String creator) {
        this.creator = creator;
    }

    @Override
    public void operationA() {
        System.out.println("Operation A from ConcreteProductA2 - " + creator);
    }
}

interface ProductB {
    void operationB();
}

class ConcreteProductB1 implements ProductB {
    public String creator;

    public ConcreteProductB1(String creator) {
        this.creator = creator;
    }

    @Override
    public void operationB() {
        System.out.println("Operation B from ConcreteProductB1 - " + creator);
    }
}

class ConcreteProductB2 implements ProductB {
    public String creator;

    public ConcreteProductB2(String creator) {
        this.creator = creator;
    }

    @Override
    public void operationB() {
        System.out.println("Operation B from ConcreteProductB2 - " + creator);
    }
}

interface ClassicAbstractFactory {
    ProductA createProductA();

    ProductB createProductB();
}

class ConcreteFactory1 implements ClassicAbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA1("ConcreteFactory1");
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB1("ConcreteFactory1");
    }
}

class ConcreteFactory2 implements ClassicAbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA2("ConcreteFactory2");
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB2("ConcreteFactory2");
    }
}
