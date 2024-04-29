package org.example.gof.structural;

import org.example.model.Product;
import org.example.model.SecondProduct;

// Шаблон декоратор позволяет вам динамически изменять поведение объекта во время работы, оборачивая их в объект класса декоратора.
//	обертка над объектом расширяющая функционал
public class Decorator {
    public static void main(String[] args) {
        Product product = new SecondProduct("second decorator");
        RedProductDecorator decorator = new RedProductDecorator(product);
        decorator.printName();
    }
}

class RedProductDecorator implements Product {
    private Product product;

    public RedProductDecorator(Product product) {
        this.product = product;
    }

    @Override
    public void printName() {
        product.printName();
        System.out.println("and it is red");
    }

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public void setName(String name) {
        product.setName(name);
    }

    @Override
    public void printClassName() {

    }

    @Override
    public void startProcess() {

    }

    @Override
    public void endProcess() {

    }
}