package com.desigin.demo.prototype.deepCopy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 深拷贝
 * 所有对象实现
 */
public class Exam1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 创建被赋值对象
        Address address = new Address(110, "北京");
        People p1 = new People(1, "Java", address);
        // 克隆 p1 对象
        People p2 = p1.clone();
        // 修改原型对象
        p1.getAddress().setCity("西安");
        // 输出 p1 和 p2 地址信息
        System.out.println("p1:" + p1.getAddress().getCity() + " p2:" + p2.getAddress().getCity());//p1:西安 p2:北京
        System.out.println(p1.hashCode()==p2.hashCode());//false
    }
    /**
     * 用户类
     */
    @Data
    @AllArgsConstructor
    static class People implements Cloneable {
        private Integer id;
        private String name;
        private Address address;
        /**
         * 重写 clone 方法
         * @throws CloneNotSupportedException
         */
        @Override
        protected People clone() throws CloneNotSupportedException {
            People people = (People) super.clone();
            people.setAddress(this.address.clone()); // 引用类型克隆赋值
            return people;
        }
        // 忽略构造方法、set、get 方法
    }
    /**
     * 地址类
     */
    @Data
    @AllArgsConstructor
    static class Address implements Cloneable {
        private Integer id;
        private String city;
        /**
         * 重写 clone 方法
         * @throws CloneNotSupportedException
         */
        @Override
        protected Address clone() throws CloneNotSupportedException {
            return (Address) super.clone();
        }
        // 忽略构造方法、set、get 方法
    }
}