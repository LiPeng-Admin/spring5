package com.atguigu5.test;

import com.atguigu5.entity.Book;
import com.atguigu5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/18 22:51
 */
public class TestBook {
    Book book = new Book();

    @Test
    public void testBook() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean13.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        //添加图书
//        book.setUserId(1);
//        book.setUsername("葵花宝典");
//        //0:未售罄，1:销售一半,2:全部销售
//        book.setUstatus("1");
//        bookService.addBook(book);

        //修改图书
//        book.setUserId(1);
//        book.setUsername("降龙十八掌");
//        book.setUstatus("2");
//        bookService.updateBook(book);

        //删除图书
//
//        book.setUserId(1);
//        bookService.deleteBook("1");

        //返回某个值
//        int count = bookService.findCount();
//        System.out.println(count);

        //返回一个对象
//        Book book = bookService.findOne("2");
//        System.out.println(book);

        //返回对象集合
//        List<Book> books = bookService.findAll();
//        System.out.println(books);


        //批量添加
//        List<Object[]> args = new ArrayList<>();
//        Object[] o1 = {"6", "qwe", "ee"};
//        Object[] o2 = {"7", "qwet", "ff"};
//        Object[] o3 = {"8", "qwety", "gg"};
//        args.add(o1);
//        args.add(o2);
//        args.add(o3);
//
//        bookService.batchAdd(args);

        //批量修改
//        List<Object[]> args = new ArrayList<>();
//        Object[] o1 = {"xx", "q", "5"};
//        Object[] o2 = {"yy", "qw", "6"};
//        Object[] o3 = {"zz", "qwe", "7"};
//        args.add(o1);
//        args.add(o2);
//        args.add(o3);
//
//        bookService.batchUpdate(args);

        //批量删除
        List<Object[]> args = new ArrayList<>();
        Object[] o1 = {"5"};
        Object[] o2 = {"6"};

        args.add(o1);
        args.add(o2);


        bookService.batchDelete(args);
    }


}
