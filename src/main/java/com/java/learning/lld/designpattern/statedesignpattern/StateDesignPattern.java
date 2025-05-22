package com.java.learning.lld.designpattern.statedesignpattern;

public class StateDesignPattern {
    public static void main(String[] args) {
        StateContext stateContext = new StateContext();
        stateContext.work();
        stateContext.next();
        stateContext.next();
        stateContext.work();
        stateContext.next();

        stateContext = new StateContext();
        stateContext.next();
        stateContext.work();
        stateContext.cancel();
        stateContext.work();
        stateContext.next();
        stateContext.work();

        stateContext = new StateContext();
        stateContext.work();
        stateContext.cancel();
        stateContext.next();
        stateContext.next();
        stateContext.work();
        stateContext.cancel();
        stateContext.next();
        stateContext.cancel();
        stateContext.work();
    }
}
