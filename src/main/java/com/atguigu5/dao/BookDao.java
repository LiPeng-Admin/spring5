package com.atguigu5.dao;

import com.atguigu5.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/18 19:58
 */

public interface BookDao {
    public void add(Book book);


    public void update(Book book);

    public void delete(String id);

    public int selectCount();

    public Book findBookInfo(String id);

    public List<Book> findAllBook();

    void batchAddBook(List<Object[]> args);

    void batchUpdateBook(List<Object[]> args);

    void batchDeleteBook(List<Object[]> args);
}
