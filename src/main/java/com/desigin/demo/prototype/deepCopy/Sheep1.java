package com.desigin.demo.prototype.deepCopy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 通过构造函数实现深拷贝
 */
public class Sheep1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 创建对象
        Address address = new Address(110, "北京");
        People p1 = new People(1, "Java", address);

        // 调用构造函数克隆对象
        People p2 = new People(p1.getId(), p1.getName(), new Address(p1.getAddress().getId(), p1.getAddress().getCity()));

        // 修改原型对象
        p1.getAddress().setCity("西安");

        // 输出 p1 和 p2 地址信息
        System.out.println("p1:" + p1.getAddress().getCity() + " p2:" + p2.getAddress().getCity());
        System.out.println(p1.hashCode()==p2.hashCode());
    }

    /**
     * 用户类
     */
    @Data
    @AllArgsConstructor
    static class People {
        private Integer id;
        private String name;
        private Address address;
        // 忽略构造方法、set、get 方法
    }

    /**
     * 地址类
     */
    @Data
    @AllArgsConstructor
    static class Address {
        private Integer id;
        private String city;
        // 忽略构造方法、set、get 方法
    }
}