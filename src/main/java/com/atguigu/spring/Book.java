package com.atguigu.spring;

import java.math.BigDecimal;

/**
 * @author lipeng
 * @version 1.0
 * @description: 演示使用set方法注入属性
 * @date 2022/9/14 21:46
 */
public class Book {

//1:创建类，定义属性和对应的 set 方法

    private String bookName;
    private String bauthor;
    private String baddress;
    private BigDecimal bprice;
    private String bpublisher;//出版社

    //set方法注入
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void setBaddress(String baddress) {
        this.baddress = baddress;
    }

    public void setBprice(BigDecimal bprice) {
        this.bprice = bprice;
    }

    public void setPublisher(String bpublisher) {
        this.bpublisher = bpublisher;
    }
    //2:在 spring 配置文件配置对象创建，配置属性注入


//
    public void bookDemo() {
        System.out.println("书名是：" + bookName + ",书作者是：" + bauthor+",书住址地："+baddress+",书的价格"+bprice+",书的出版社："+bpublisher);
    }
}
