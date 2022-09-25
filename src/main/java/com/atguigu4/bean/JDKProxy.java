package com.atguigu4.bean;

import com.atguigu4.dao.UserDao;
import com.atguigu4.dao.impl.UserDaoImpl;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/18 10:47
 */
@Component
public class JDKProxy {
    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        //newProxyInstance:返回指定接口的代理类的实例，该接口将方法调用分派给指定的调用处理程序。
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int sum = dao.add(1, 2);
        System.out.println(sum);

    }


}

//创建代理对象代码
class UserDaoProxy implements InvocationHandler {
    //有参数构造传递
    private Object object;

    public UserDaoProxy(Object object) {
        this.object = object;
    }

    //增强逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前
        System.out.println("方法之前执行" + method.getName() + ",传递的参数：" + Arrays.toString(args));
        //被增强的方法执行
        Object res = method.invoke(object, args);
        //方法之后
        System.out.println("方法之后执行" + object);

        return res;
    }
}
