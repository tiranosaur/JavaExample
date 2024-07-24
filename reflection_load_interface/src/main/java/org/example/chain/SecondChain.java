package org.example.chain;

public class SecondChain implements Chain {
    @Override
    public void printName() {
        System.out.println(this.getClass().getSimpleName());
    }
}
