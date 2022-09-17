package com.atguigu2.collectiontype;

import java.util.List;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/17 0:09
 */
public class Book {
    private List<String> booList;

    public void setBooList(List<String> booList) {
        this.booList = booList;
    }
    public void test() {
        System.out.println(booList);
    }
}
