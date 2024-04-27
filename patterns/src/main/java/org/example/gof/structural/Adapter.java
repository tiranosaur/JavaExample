package org.example.gof.structural;

import org.example.model.Product;
import org.example.model.SecondProduct;

// Шаблон позволяет обернуть несовместимые объекты в адаптер, чтобы сделать их совместимыми с другим классом
/*
Adapter (Адаптер) - применяется при необходимости использовать классы вместе с несвязанными интерфейсами.
Поведение адаптируемого класса при этом изменяется на необходимое (interface to an object);
 */
public class Adapter {
    public static void main(String[] args) {
        Product product = new SecondProduct("second");
        ProductAdapter adapter = new ProductAdapter(product);
        adapter.test();
    }
}

class ProductAdapter {
    private Product product;

    public ProductAdapter(Product product) {
        this.product = product;
    }

    public void test() {
        product.printName();
    }
}