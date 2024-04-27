package org.example.gof.structural;

import org.example.model.Product;
import org.example.model.SecondProduct;

//Шаблон мост — это предпочтение композиции над наследованием. Детали реализации передаются из одной иерархии в другой объект с отдельной иерархией.
public class Bridge {
    public static void main(String[] args) {
        Product product = new SecondProduct("second bridge");
        Color color = new Red();
        ColoredProduct coloredProduct = new ColoredProduct(color, product);

        coloredProduct.print();
    }
}

abstract class ProductWithColor {
    protected Color color;

    public ProductWithColor(Color color) {
        this.color = color;
    }

    abstract void print();
}

class ColoredProduct extends ProductWithColor {
    private final Product product;

    public ColoredProduct(Color color, Product product) {
        super(color);
        this.product = product;
    }

    @Override
    void print() {
        color.printColor();
        product.printName();
    }
}

interface Color {
    void printColor();
}

class Red implements Color {
    public void printColor() {
        System.out.println("Red");
    }
}

class Green implements Color {
    public void printColor() {
        System.out.println("Green");
    }
}
