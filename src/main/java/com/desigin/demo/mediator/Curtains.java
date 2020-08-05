package com.desigin.demo.mediator;


public class Curtains extends Colleague {

    public Curtains(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }
    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }
    public void upCurtains() {
        System.out.println("I am holding Up Curtains!");
    }
}