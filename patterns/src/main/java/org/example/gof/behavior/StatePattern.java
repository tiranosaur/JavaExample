package org.example.gof.behavior;

import lombok.Setter;
// Используется втех случаях, когда вовремя выполнения программы объект должен менять своё поведение взависимости отсвоего состояния.
// Шаблон позволяет менять поведение класса при изменении состояния.
public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context();

        context.setState(new ConcreteStateA());
        context.request();

        context.setState(new ConcreteStateB());
        context.request();
    }
}

@Setter
class Context {
    private State state;

    public void request() {
        state.handleRequest();
    }
}

interface State {
    void handleRequest();
}

class ConcreteStateA implements State {
    @Override
    public void handleRequest() {
        System.out.println("Handling request in State A");
    }
}

class ConcreteStateB implements State {
    @Override
    public void handleRequest() {
        System.out.println("Handling request in State B");
    }
}