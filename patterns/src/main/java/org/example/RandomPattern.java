package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPattern {
    public static void main(String[] args) {
        Random rand = new Random();
        List<String> list = new ArrayList<>();
        list.add("Singleton (Одиночка)");
        list.add("Factory (Фабрика)");
        list.add("Abstract Factory (Абстрактная фабрика)");
        list.add("Builder (Строитель)");
        list.add("Prototype (Прототип)");
        list.add("Adapter (Адаптер)");
        list.add("Composite (Компоновщик)");
        list.add("Proxy (Заместитель)");
        list.add("Flyweight (Легковес)");
        list.add("Facade (Фасад)");
        list.add("Bridge (Мост)");
        list.add("Decorator (Декоратор)");
        list.add("Template Method (Шаблонный метод)");
        list.add("Mediator (Посредник)");
        list.add("Chain of Responsibility (Цепочка обязанностей)");
        list.add("Observer (Наблюдатель)");
        list.add("Strategy (Стратегия)");
        list.add("Command (Команда)");
        list.add("State (Состояние)");
        list.add("Visitor (Посетитель)");
        list.add("Interpreter (Интерпретатор)");
        list.add("Iterator (Итератор)");
        list.add("Memento (Хранитель)");
        System.out.println(list.get(rand.nextInt(list.size())));
    }
}
