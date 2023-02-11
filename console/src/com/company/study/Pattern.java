package com.company.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pattern {
    private static List<String> patterns = new ArrayList<>(List.of(
            "Singleton (одиночка)",
            "Простая фабрика (Simple Factory)",
            "Абстрактная фабрика (Abstract Factory)",
            "Строитель (Builder)",
            "Прототип (Prototype)",
            "Цепочка обязанностей (Chain of Responsibility)",
            "Команда (Command)",
            "Итератор (Iterator)",
            "Посредник (Mediator)",
            "Хранитель (Memento)",
            "Наблюдатель (Observer)",
            "Посетитель (Visitor)",
            "Стратегия (Strategy)",
            "Состояние (State)",
            "Шаблонный метод (Template Method)",
            "Адаптер (Adapter)",
            "Мост (Bridge)",
            "Компоновщик (Composite)",
            "Декоратор (Decorator)",
            "Фасад (Facade)",
            "Приспособленец (Flyweight)",
            "Заместитель (Proxy)"
    ));

    public static void get() {
        Collections.shuffle(patterns);
        System.out.println(patterns.get(0));
    }
}
