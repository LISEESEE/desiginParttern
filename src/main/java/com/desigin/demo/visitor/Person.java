package com.desigin.demo.visitor;

public abstract class Person {

    /**
     * 提供一个方法，让访问者可以访问
     * @param action a
     */
    public abstract void accept(Action action);
}