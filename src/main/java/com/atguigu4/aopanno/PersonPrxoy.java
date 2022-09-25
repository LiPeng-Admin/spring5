package com.atguigu4.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/18 17:49
 */
@Component
@Aspect
@Order(1)
public class PersonPrxoy {
    @Before(value="execution(* com.atguigu4.aopanno.User.add(..))")
    public void before() throws Exception {
        System.out.println("PersonPrxoy started...");

    }
}
