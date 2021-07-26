package com.desigin.demo.adapter.objectAdapter;

//被适配的类
class Voltage220V {
    //输出 220V 的电压，不变
    public int output220V() {
        int src = 220;
        System.out.println("电压=" + src + "伏");
        return src;
    }
}