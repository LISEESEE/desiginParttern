package com.desigin.demo.composite;

import java.util.ArrayList;
import java.util.List;

//University 就是 Composite ,  可以管理 College
public class University extends OrganizationComponent {
    List<OrganizationComponent> organizationComponents = new ArrayList<>();
    // 构造器
    public University(String name, String des) {
        super(name, des);
    }

    // 重 写 add
     @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponents.add(organizationComponent);
    }

    // 重 写 remove
     @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    // print 方法，就是输出 University  包含的学院
    @Override
    protected void print() {
        System.out.println("--------------" + getName() + "--------------");
        //遍历 organizationComponents
        for (OrganizationComponent organizationComponent : organizationComponents) {
            organizationComponent.print();
        }
    }
}