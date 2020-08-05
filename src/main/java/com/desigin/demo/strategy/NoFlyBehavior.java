package com.desigin.demo.strategy;


public class NoFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println(" 不会飞翔	");
    }
}