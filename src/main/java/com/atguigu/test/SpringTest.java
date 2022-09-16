package com.atguigu.test;

import com.atguigu.spring.Book;
import com.atguigu.spring.Orders;
import com.atguigu.spring.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/14 0:04
 */
public class SpringTest {
    @Test
    public void test()  {
        //1：加载spring 配置文件
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        //2：获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.addUser();


    }
    @Test
    public void testBook() {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);
        book.bookDemo();


    }
    @Test
    public void testOrder() {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Orders order = context.getBean("order", Orders.class);
        order.orderDemo();
    }
}
