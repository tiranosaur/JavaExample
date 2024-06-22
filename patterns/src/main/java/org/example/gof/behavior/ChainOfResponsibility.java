package org.example.gof.behavior;

import lombok.AllArgsConstructor;
import lombok.Data;

//Цепочка обязанностей (Chain of Responsibility) - цепочка обязанностей помогает строить цепочки объектов.
//	Запрос входит с одного конца и проходит через каждый объект, пока не найдет подходящий обработчик. Один абстрактный объект. Несколько его обработчиков.
//	последовательно пробуем
public class ChainOfResponsibility {
    public static void main(String[] args) throws Exception {
        Step step1 = new StepImpl("111", null);
        Step step2 = new StepImpl("222", step1);
        Step step3 = new StepImpl("333", step2);
        Step step4 = new StepImpl("444", step3);

        step4.execute();
    }
}

interface Step {
    void execute();
}

class StepImpl implements Step {
    private final Step step;
    private final String type;

    public StepImpl(String type, Step step) {
        this.step = step;
        this.type = type;
    }

    @Override
    public void execute() {
        System.out.println("Executing " + type);
        // exit
        if ("333".equals(type)) {
            System.out.println("Executed successfully");
            return;
        }
        //next
        if (null != step) {
            step.execute();
        }
    }
}

