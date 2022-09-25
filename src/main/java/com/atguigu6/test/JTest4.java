package com.atguigu6.test;

import com.atguigu6.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/25 13:42
 */
@RunWith(SpringJUnit4ClassRunner.class)//单元测试框架
@ContextConfiguration("classpath:bean14.xml") //加载配置文件
public class JTest4 {
    @Autowired
    private UserService userService;

    @Test
    public void test() throws Exception {
        userService.accountMoney();
    }
}
