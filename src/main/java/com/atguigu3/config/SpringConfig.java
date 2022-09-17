package com.atguigu3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/17 23:36
 */
//作为配置类，替代xml 配置文件
@Configuration
//开启组件扫描
@ComponentScan(basePackages = {"com.atguigu3"})// 等价于<context:component-scan base-package="com.atguigu3"></context:component-scan>
public class SpringConfig {
}
