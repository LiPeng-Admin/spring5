package com.atguigu.bean;

/**
 * @author lipeng
 * @version 1.0
 * @description: 员工类
 * @date 2022/9/15 23:30
 */
public class Emp {
    private String ename;
    private String gender;
    //员工属于某一个部门，使用对象形式表示
    private Dept dept;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    //生成dept的get方法
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void add() {
        System.out.println("员工姓名：" + ename + ",员工性别：" + gender + ",员工所在部门：" + dept);
    }
}
