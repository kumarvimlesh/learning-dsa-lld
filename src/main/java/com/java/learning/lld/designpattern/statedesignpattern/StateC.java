package com.java.learning.lld.designpattern.statedesignpattern;

public class StateC implements State {

    @Override
    public void next(StateContext stateContext) {
        System.out.println("Final state is reached");
    }

    @Override
    public void cancel(StateContext stateContext) {
        System.out.println("Cancellation not allowed");
    }

    @Override
    public void work() {
        System.out.println("State C performing work");
    }
}
