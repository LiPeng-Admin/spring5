package com.atguigu.bean;

/**
 * @author lipeng
 * @version 1.0
 * @description: 部门类
 * @date 2022/9/15 23:28
 */
public class Dept {
    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
