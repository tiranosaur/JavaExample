package org.example.gof.creational;

public class Singleton {
    public static void main(String[] args) {
        System.out.println(SimpliestSingleton.instance.equals(SimpliestSingleton.instance));

        DoubleCheckedSingleton singleton1 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton singleton2 = DoubleCheckedSingleton.getInstance();
        System.out.println(singleton1.equals(singleton2));
    }
}

enum SimpliestSingleton {
    instance;
    private String level;
    SimpliestSingleton() {
        // ctor
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}

class SimpleSingleton {
    public static SimpleSingleton instance = new SimpleSingleton();
}

class SynchronizedSingleton {
    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {
    }

    public synchronized static SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}

class DoubleCheckedSingleton {
    private volatile static DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {
    }

    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}