package com.desigin.demo.proxy.static1;

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println(" 老师授课中	。。。。。");
    }
}