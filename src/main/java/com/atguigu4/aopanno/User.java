package com.atguigu4.aopanno;

import org.springframework.stereotype.Component;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/18 15:08
 */
//被增强类
@Component(value="user")
public class User {
    public void add() {
        System.out.println("user add..");
    }
}
