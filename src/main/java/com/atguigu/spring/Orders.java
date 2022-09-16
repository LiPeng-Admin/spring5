package com.atguigu.spring;

/**
 * @author lipeng
 * @version 1.0
 * @description: 使用有参数的构造器注入
 * @date 2022/9/14 22:51
 */
public class Orders {
    //（1）创建类，定义属性，创建属性对应有参数构造方法
    private  String orderName;
    private String orderAddress;


    public Orders(String orderName, String orderAddress) {
        this.orderName = orderName;
        this.orderAddress = orderAddress;
    }
    //（2）在 spring 配置文件中进行配置

    //3:
    public void orderDemo(){
        System.out.println("订单名："+orderName+",订单地址："+orderAddress);
    }
}
