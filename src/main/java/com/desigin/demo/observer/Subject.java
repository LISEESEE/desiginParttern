package com.desigin.demo.observer;

//被观察者接口, 让 WeatherData 来实现
public interface Subject {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();
}