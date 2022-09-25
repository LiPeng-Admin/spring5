package com.atguigu4.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/18 11:28
 */
@Configuration
@ComponentScan(basePackages={"com.atguigu4"})
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringConfig {
}
