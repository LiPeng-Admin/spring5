package com.atguigu3.service;

import com.atguigu3.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lipeng
 * @version 1.0
 * @description: Spring 针对 Bean 管理中创建对象提供注解
 * （1）@Component
 * （2）@Service
 * （3）@Controller
 * （4）@Repository
 * * 上面四个注解功能是一样的，都可以用来创建 bean 实例
 * <p>

 * @date 2022/9/17 19:42
 */
/**
 * @description:* Spring 针对 Bean 管理中基于注解方式  实现属性注入
 *  * @Autowired：根据属性类型进行自动装配
 *  * @Qualifier：根据名称进行注入 这个@Qualifier 注解的使用，和上面@Autowired 一起使用
 *  * @Resource：可以根据类型注入，可以根据名称注入
 *  * @Value：注入普通类型属性
 * @param:
 * @param
 * @return:
 * @author lipeng
 * @date: 2022/9/17 23:16
 */
//在注解里面，value属性值可以省略不写
// 默认值是类名称，首字母小写
//@Component(value = "userService")//<bean id="userService" class="com.atguigu3.service.UserService">
//@Controller
//@Repository
@Service

public class UserService {
    //定义userDao类型属性
    //不需要添加set方法
    //添加注入属性注解
//    @Autowired //根据类型进行注入
//    @Qualifier(value="userDaoImpl1") //@Qualifier 注解的使用，和上面@Autowired 一起使用
//    private UserDao userDao;

    // @Resource
//    private UserDao userDao; //根据类型注入
    @Resource(name = "userDaoImpl1") //根据名称进行注入
    private UserDao userDao;
    @Value(value = "test")
    private String name;


    public void addUser() {
        System.out.println("add sevices...."+name);
        userDao.update();

    }
}
