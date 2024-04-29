package org.example.gof.behavior;

import lombok.AllArgsConstructor;
import lombok.Setter;

//Алгоритм стратегии может быть изменен во время выполнения программы.
// Позволяет переключаться между алгоритмами или стратегиями в зависимости от ситуации.
public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPaymentStrategy("1234-5678-9012-3456", "12/24", "123"));
        cart.checkout(100);

        cart.setPaymentStrategy(new PayPalPaymentStrategy("example@example.com", "password123"));
        cart.checkout(200);
    }
}

@Setter
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

interface PaymentStrategy {
    void pay(int amount);
}

@AllArgsConstructor
class CreditCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit card.");
    }
}

@AllArgsConstructor
class PayPalPaymentStrategy implements PaymentStrategy {
    private String email;
    private String password;

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with PayPal.");
    }
}
