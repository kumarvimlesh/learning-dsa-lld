package com.java.learning.lld.designpattern.statedesignpattern;

public class StateA implements State{
    @Override
    public void next(StateContext stateContext) {
        System.out.println("Transition : A -> B");
        stateContext.setState(new StateB());
    }

    @Override
    public void cancel(StateContext stateContext) {
        System.out.println("Transition : A -> A");
        stateContext.setState(new StateA());
    }

    public void work(){
        System.out.println("State A performing work");
    }
}
