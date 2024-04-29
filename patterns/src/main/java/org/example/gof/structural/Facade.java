package org.example.gof.structural;

import lombok.AllArgsConstructor;
import org.example.model.Product;
import org.example.model.ThirdProduct;

//Фасад предоставляет упрощенный интерфейс для сложной системы. неколько действий над объектом в одном метода
public class Facade {
    public static void main(String[] args) {
        ProductFacade facade = new ProductFacade(new ThirdProduct("third product"));
        facade.turnOn();
        facade.turnOff();
    }
}

@AllArgsConstructor
class ProductFacade {
    private Product product;

    public void turnOn() {
        product.printName();
        product.startProcess();
    }

    public void turnOff() {
        product.printClassName();
        product.endProcess();
    }
}