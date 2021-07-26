package com.desigin.demo.bridge;

abstract public class Phone{
    private Brand brand;

    public Phone(Brand brand) {
        super();
        this.brand = brand;
    }
    protected void open(){
        brand.open();
    }
    protected void close(){
        brand.close();
    }
    protected void call(){
        brand.call();
    }
}
