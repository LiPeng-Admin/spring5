package com.atguigu2.test;

import com.atguigu2.autowire.Employee;
import com.atguigu2.bean.Orders;
import com.atguigu2.collectiontype.Course;
import com.atguigu2.factorybean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/17 10:57
 */
public class TestBean {
    @Test
    public void test() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean7.xml");
        Course bean = context.getBean("myBean", Course.class);
//        MyBean bean1 = context.getBean("myBean", MyBean.class);
        System.out.println(bean);
//        System.out.println(bean1);
    }
    @Test
    public void test1() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean8.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean8.xml");
        Orders order = context.getBean("order", Orders.class);
        System.out.println("第四步，获取创建bean实例对象");
        System.out.println(order);

        //手动让bean实例销毁
        context.close();
    }
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean9.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee);
    }
}
