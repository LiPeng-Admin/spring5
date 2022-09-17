package com.atguigu2.collectiontype;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/16 23:52
 */
public class Course {
    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
