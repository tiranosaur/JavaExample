package org.example.chain;

public class FirstChain implements Chain {
    @Override
    public void printName() {
        System.out.println(this.getClass().getSimpleName());
    }
}
