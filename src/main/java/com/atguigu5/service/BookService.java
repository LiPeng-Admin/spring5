package com.atguigu5.service;

import com.atguigu5.dao.BookDao;
import com.atguigu5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/18 19:58
 */
@Service
public class BookService {
    //注入dao
    @Autowired
    private BookDao bookDao;
    //添加的方法
    public void addBook(Book book) {
        bookDao.add(book);
    }
    //修改的方法
    public void updateBook(Book book) {
        bookDao.update(book);
    }
    //删除的方法
    public void deleteBook(String id){
        bookDao.delete(id);
    }

    //查询表中有多少条记录
    public int findCount(){
       return bookDao.selectCount();
    }
    //查询返回的对象
    public Book findOne(String id){
        return bookDao.findBookInfo(id);
    }
    //查询返回集合
    public List<Book> findAll(){
        return bookDao.findAllBook();

    }
    //批量添加
    public void batchAdd(List<Object[]> args){
        bookDao.batchAddBook(args);
    }

    //批量修改
    public void batchUpdate(List<Object[]> args){
        bookDao.batchUpdateBook(args);
    }

    //批量删除
    public void batchDelete(List<Object[]> args){
        bookDao.batchDeleteBook(args);
    }
}
