package com.atguigu2.test;

import com.atguigu2.collectiontype.Stu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/16 23:19
 */
public class StuTest {
   @Test
    public void test() throws Exception {
       ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
      Stu stu = context.getBean("stu", Stu.class);
       stu.test();
   }
}
