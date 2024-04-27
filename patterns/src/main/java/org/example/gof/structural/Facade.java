package org.example.gof.structural;

//Фасад предоставляет упрощенный интерфейс для сложной системы. неколько действий над объектом в одном метода
public class Facade {
    public static void main(String[] args) {
        SubsystemFacade subsystemFacade = new SubsystemFacade();
        subsystemFacade.operation();
    }
}

class SubsystemFacade {
    private final SubsystemA subsystemA;
    private final SubsystemB subsystemB;
    private final SubsystemC subsystemC;

    public SubsystemFacade() {
        this.subsystemA = new SubsystemA();
        this.subsystemB = new SubsystemB();
        this.subsystemC = new SubsystemC();
    }

    public void operation() {
        subsystemA.operationA();
        subsystemB.operationB();
        subsystemC.operationC();
    }
}

class SubsystemA {
    public void operationA() {
        System.out.println("Subsystem A operation");
    }
}

class SubsystemB {
    public void operationB() {
        System.out.println("Subsystem B operation");
    }
}

class SubsystemC {
    public void operationC() {
        System.out.println("Subsystem C operation");
    }
}