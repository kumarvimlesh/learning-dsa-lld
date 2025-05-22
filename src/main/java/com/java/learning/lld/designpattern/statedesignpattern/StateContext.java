package com.java.learning.lld.designpattern.statedesignpattern;

public class StateContext {
    private State state;

    public StateContext() {
        this.state = new StateA();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void next(){
        state.next(this);
    }

    public void cancel(){
        state.cancel(this);
    }

    public void work(){
        state.work();
    }
}
