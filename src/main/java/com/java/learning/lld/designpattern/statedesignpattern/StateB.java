package com.java.learning.lld.designpattern.statedesignpattern;

public class StateB implements State{

    @Override
    public void next(StateContext stateContext) {
        System.out.println("Transition : B -> C");
        stateContext.setState(new StateC());
    }

    @Override
    public void cancel(StateContext stateContext) {
        System.out.println("Transition : B -> A");
        stateContext.setState(new StateA());
    }

    @Override
    public void work(){
        System.out.println("State B performing work");
    }
}
