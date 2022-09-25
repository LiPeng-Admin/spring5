package com.atguigu6.test;
import com.atguigu6.service.UserService;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/25 14:54
 */

@SpringJUnitConfig(locations = "classpath:bean14.xml") //复合注解
public class JTest5 {
    @Autowired
    private UserService userService;

    @Test
    public void test() throws Exception {
        userService.accountMoney();

    }

}
