package org.example.gof.behavior;

// Шаблон посетитель позволяет добавлять будущие операции для объектов без их модифицирования. расширяет интерфейс
public class VisitorPattern {
    public static void main(String[] args) {
        ConcreteVisitor visitor = new ConcreteVisitor();

        ElementA elementA = new ElementA();

        elementA.accept(visitor);
    }
}

interface Visitor {
    void visit(ElementA elementA);
}

class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ElementA elementA) {
        elementA.operationA();
    }
}


interface Visitable {
    void accept(Visitor visitor);
}

class ElementA implements Visitable {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    void operationA() {
        System.out.println("Performing operation A on Element A");
    }
}