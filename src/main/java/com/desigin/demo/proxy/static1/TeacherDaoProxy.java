package com.desigin.demo.proxy.static1;

//代理对象,静态代理
public class TeacherDaoProxy implements ITeacherDao {
    // 目标对象，通过接口来聚合
    private ITeacherDao target;

    //构造器
    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理	完成某些操作。。。。。 ");
        System.out.println("提交。。。。。");
    }
}
/**
 * 开始代理	完成某些操作。。。。。
 * 提交。。。。。
 **/