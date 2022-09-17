package com.atguigu2.test;

import com.atguigu2.collectiontype.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/17 0:26
 */
public class BookTest {
    @Test
    public void test() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");
        Book book = context.getBean("book", Book.class);
        book.test();

    }
}
