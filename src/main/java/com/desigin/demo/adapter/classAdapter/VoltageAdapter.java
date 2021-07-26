package com.desigin.demo.adapter.classAdapter;

public class VoltageAdapter extends Voltage220V implements IVoltage5V{
    @Override
    public int output5V() {
        int src = super.output220V();
        int des = src / 44;
        return des;
    }
}
