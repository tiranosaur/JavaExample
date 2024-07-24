package org.example.chain;

public class CustomChain implements Chain {
    @Override
    public void printName() {
        System.out.println(this.getClass().getSimpleName());
    }
}
