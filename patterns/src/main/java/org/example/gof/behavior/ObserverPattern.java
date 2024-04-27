package org.example.gof.behavior;

import java.util.ArrayList;
import java.util.List;

//Шаблон определяет зависимость между объектами, чтобы при изменении состояния одного из них зависимые от него узнавали об этом.
//	в наблюдателе перебирает список подписчиков и вызывает метод
public class ObserverPattern {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        CurrentConditionsObserver observer = new CurrentConditionsObserver();

        weatherStation.register(observer);
        observer.setSubject(weatherStation);

        weatherStation.setTemperature(80);
        weatherStation.setTemperature(82);
        weatherStation.setTemperature(78);
    }
}

interface Observer {
    void update();

    void setSubject(Subject subject);
}

class CurrentConditionsObserver implements Observer {
    private Subject weatherStation;

    @Override
    public void update() {
        if (weatherStation instanceof WeatherStation) {
            WeatherStation station = (WeatherStation) weatherStation;
            System.out.println("Current conditions: " + station.getTemperature() + "F degrees");
        }
    }

    @Override
    public void setSubject(Subject subject) {
        this.weatherStation = subject;
    }
}

interface Subject {
    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObservers();
}

class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }
}