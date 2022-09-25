package com.atguigu4.dao;

/**
 * @author lipeng
 * @version 1.0
 *
 * @description:
 * 什么是 AOP
 * （1）面向切面编程（方面），利用 AOP 可以对业务逻辑的各个部分进行隔离，从而使得
 * 业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。
 * （2）通俗描述：不通过修改源代码方式，在主干功能里面添加新功能
 * AOP 底层使用动态代理
 * （1）有两种情况动态代理
 * 第一种 有接口情况，使用 JDK 动态代理    创建接口实现类代理对象，增强类的方法
 *
   第二种 没有接口情况，使用 CGLIB 动态代理    创建子类的代理对象，增强类的方法
 *
 * @date 2022/9/18 10:31
 */
/**
 * @description: 编写 JDK 动态代理代码
 * （1）创建接口，定义方法
 * （2）创建接口实现类，实现方法
 * （3）使用 Proxy 类创建接口代理对象
 *
 * @param:
 * @param
 * @return:
 * @author lipeng
 * @date: 2022/9/18 10:44
 */
public interface UserDao {
    public int add(int a,int b);
    public String update(String id);
}
