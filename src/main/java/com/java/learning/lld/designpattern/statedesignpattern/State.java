package com.java.learning.lld.designpattern.statedesignpattern;

public interface State {
    void next(StateContext stateContext);
    void cancel(StateContext stateContext);
    void work();
}
