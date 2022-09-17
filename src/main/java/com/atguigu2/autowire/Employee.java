package com.atguigu2.autowire;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/17 15:03
 */
public class Employee {
    private Deptment deptment;

    public void setDeptment(Deptment deptment) {
        this.deptment = deptment;
    }

    public void test() {
        System.out.println(deptment);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "deptment=" + deptment +
                '}';
    }

}
