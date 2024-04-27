package org.example.gof.behavior;

import lombok.AllArgsConstructor;
import lombok.Data;

//Позволяет вам инкапсулировать действия в объекты. предоставление средств, для разделения клиента и получателя.
//	Интерфейс который реализуется в классах которые управляют основный объектом
public class CommandPattern {
    public static void main(String[] args) {
        Bulb bulb = new Bulb();
        TurnOnCommand turnOnCommand = new TurnOnCommand(bulb);
        TurnOffCommand turnOffCommand = new TurnOffCommand(bulb);

        turnOnCommand.turn();
        turnOffCommand.turn();
    }
}

class Bulb {
    public void turnOn() {
        System.out.println("Turn On");
    }

    public void turnOff() {
        System.out.println("Turn Off");
    }
}

interface Command {
    void turn();
}

@AllArgsConstructor
class TurnOnCommand implements Command {
    private Bulb bulb;

    public void turn() {
        bulb.turnOn();
    }
}

@AllArgsConstructor
class TurnOffCommand implements Command {
    private Bulb bulb;

    public void turn() {
        bulb.turnOff();
    }
}