package com.atguigu6.test;

import com.atguigu6.config.TXConfig;
import com.atguigu6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lipeng
 * @version 1.0
 * @description:转账的测试
 * @date 2022/9/24 16:40
 */
public class TestUserAccount {
    @Test
    public void test() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean14.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.accountMoney();
    }
    @Test
    public void test2() {
        ApplicationContext context=new AnnotationConfigApplicationContext(TXConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.accountMoney();
    }


}
