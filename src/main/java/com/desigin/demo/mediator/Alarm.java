package com.desigin.demo.mediator;

//具体的同事类
public class Alarm extends Colleague {

    //构造器
    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        //在创建 Alarm 同事对象时，将自己放入到 ConcreteMediator 对象中[集合]
        mediator.register(name, this);
    }

    public void sendAlarm(int stateChange) {
        sendMessage(stateChange);
    }

    @Override
    public void sendMessage(int stateChange) {
        // 调 用 的 中 介 者 对 象 的 getMessage
        this.getMediator().getMessage(stateChange, this.name);
    }
}