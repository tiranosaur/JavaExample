package org.example.gof.structural;

import org.example.model.FirstProduct;
import org.example.model.Product;
import org.example.model.SecondProduct;

import java.util.ArrayList;
import java.util.List;

//Шаблон компоновщик позволяет клиентам работать с индивидуальными объектами в едином стиле.
public class Composite {
    public static void main(String[] args) {
        Product product1 = new FirstProduct("first product");
        Product product2 = new SecondProduct("second product");

        MyComposite myComposite = new MyComposite();
        myComposite.add(product1);
        myComposite.add(product2);
        myComposite.print();
    }
}

class MyComposite {
    private final List<Product> productList;

    public MyComposite() {
        productList = new ArrayList<>();
    }

    public void add(Product product) {
        productList.add(product);
    }

    public void clear() {
        productList.clear();
    }

    public void print() {
        for (Product product : productList) {
            product.printName();
        }
    }

}
