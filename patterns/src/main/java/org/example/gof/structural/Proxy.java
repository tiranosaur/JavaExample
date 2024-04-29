package org.example.gof.structural;

import org.example.model.Product;
import org.example.model.SecondProduct;

// Используя шаблон заместитель, класс отображает функциональность другого класса.
public class Proxy {
    public static void main(String[] args) {
        Product product = new SecondProduct();
        ProxyProduct proxyProduct = new ProxyProduct(product);
        proxyProduct.setName("xxx");

        System.out.println(proxyProduct.getName());
        proxyProduct.printName();
    }
}

class ProxyProduct implements Product {
    private final Product product;

    public ProxyProduct(Product product) {
        this.product = product;
    }

    @Override
    public void printName() {
        product.printName();
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
