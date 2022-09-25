package com.atguigu4.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/18 15:12
 */
//增强类
@Component
@Aspect //生成代理对象
@Order(3)
public class UserProxy {

    //相同切入点抽取
    @Pointcut(value = "execution(* com.atguigu4.aopanno.User.add(..))")
    public void pointDemo(){

    }
    //前置通知
    //@Before注解表示前置通知
    @Before(value = "pointDemo()")
    public void before() throws Exception {
        System.out.println("before...");
    }

    //@After注解表示最终通知
    @After(value = "pointDemo()")
    public void after() throws Exception {
        System.out.println("after...");
    }

    //后置通知（返回通知
    @AfterReturning(value = "pointDemo()")
    public void AfterReturning() throws Exception {
        System.out.println("AfterReturning...");

    }
    //异常通知

    @AfterThrowing(value = "pointDemo()")
    public void AfterThrowing() throws Exception {
        System.out.println("AfterThrowing...");
    }
    //环绕通知

    @Around(value = "pointDemo()")
    public void Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前通知");
        proceedingJoinPoint.proceed();

        System.out.println("环绕之后通知");
    }
}
