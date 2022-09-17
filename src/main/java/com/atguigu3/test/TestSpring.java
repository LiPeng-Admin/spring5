package com.atguigu3.test;

import com.atguigu3.config.SpringConfig;
import com.atguigu3.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/17 20:16
 */
public class TestSpring {
    @Test
    public void test() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean11.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.addUser();
    }
    @Test
    public void test2() {
        //加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.addUser();
    }
}
