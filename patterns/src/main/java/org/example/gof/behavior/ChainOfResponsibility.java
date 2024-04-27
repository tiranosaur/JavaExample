package org.example.gof.behavior;

import lombok.AllArgsConstructor;
import lombok.Data;

//Цепочка обязанностей (Chain of Responsibility) - цепочка обязанностей помогает строить цепочки объектов.
//	Запрос входит с одного конца и проходит через каждый объект, пока не найдет подходящий обработчик. Один абстрактный объект. Несколько его обработчиков.
//	последовательно пробуем
public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler defaultHandler = new DefaultHandler();

//        Check console!!!
//        handler2.setNextHandler(defaultHandler);
        handler1.setNextHandler(handler2);

        Request request1 = new Request("Type1");
        Request request2 = new Request("Type2");
        Request request3 = new Request("Type3");

        handler1.handleRequest(request1);
        handler1.handleRequest(request2);
        handler1.handleRequest(request3);
        System.out.println("_------------------------------_");
        handler1
                .handleRequest(request1)
                .handleRequest(request2)
                .handleRequest(request3);
    }
}

@Data
@AllArgsConstructor
class Request {
    private String type;
}

interface Handler {
    Handler handleRequest(Request request);

    void setNextHandler(Handler handler);
}

@Data
class ConcreteHandler1 implements Handler {
    private Handler nextHandler;

    @Override
    public Handler handleRequest(Request request) {
        if (request.getType().equals("Type1")) {
            System.out.println("Request handled by ConcreteHandler1");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("End of chain. Request not handled.");
        }
        return this;
    }
}

@Data
class DefaultHandler implements Handler {
    private Handler nextHandler;

    @Override
    public Handler handleRequest(Request request) {
        System.out.println("Default hanler xxxxx");
        return this;
    }
}

@Data
class ConcreteHandler2 implements Handler {
    private Handler nextHandler;

    @Override
    public Handler handleRequest(Request request) {
        if (request.getType().equals("Type2")) {
            System.out.println("Request handled by ConcreteHandler2");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("End of chain. Request not handled.");
        }
        return this;
    }
}

