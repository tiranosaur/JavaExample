package org.example.gof.behavior;

// определяет каркас выполнения определённого алгоритма, но реализацию самих этапов делегирует дочерним классам.
//	абстрактный класс
public class TemplateMethodPattern {
    public static void main(String[] args) {
        AbstractAlgorithm algorithm = new ConcreteAlgorithm();
        algorithm.execute();
    }
}

abstract class AbstractAlgorithm {
    public final void execute() {
        step1();
        step2();
        step3();
    }

    protected abstract void step1();

    protected abstract void step2();

    protected void step3() {
        System.out.println("Default implementation of step3");
    }
}

class ConcreteAlgorithm extends AbstractAlgorithm {
    @Override
    protected void step1() {
        System.out.println("Step 1 implementation");
    }

    @Override
    protected void step2() {
        System.out.println("Step 2 implementation");
    }

    @Override
    protected void step3() {
        System.out.println("Custom step3 implementation");
    }
}