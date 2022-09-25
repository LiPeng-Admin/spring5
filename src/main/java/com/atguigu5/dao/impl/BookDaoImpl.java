package com.atguigu5.dao.impl;

import com.atguigu5.dao.BookDao;
import com.atguigu5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/18 19:58
 */
@Repository
public class BookDaoImpl implements BookDao {

    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        String sql="INSERT INTO t_book values(?,?,?)";
        int add = jdbcTemplate.update(sql, book.getUserId(), book.getUsername(), book.getUstatus());
        System.out.println(add);
    }

    @Override
    public void update(Book book) {
        String sql="UPDATE t_book SET ustatus=?,username=? WHERE user_id=?";
        int update = jdbcTemplate.update(sql, book.getUstatus(), book.getUsername(), book.getUserId());
        System.out.println(update);
    }

    @Override
    public void delete(String id) {
        String sql="DELETE FROM t_book WHERE user_id=?";
        int delete = jdbcTemplate.update(sql, id);
        System.out.println(delete);

    }

    @Override
    public int selectCount() {
        String sql="SELECT count(*) FROM t_book";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        return integer;
    }

    @Override
    public Book findBookInfo(String id) {
        String sql="SELECT * FROM t_book WHERE user_id=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> findAllBook() {
        String sql="SELECT * FROM t_book";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        return books;
    }

    @Override
    public void batchAddBook(List<Object[]> args) {
        String sql="INSERT INTO t_book values(?,?, ?)";
        int[] batchUpdate = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(Arrays.toString(batchUpdate));

    }

    @Override
    public void batchUpdateBook(List<Object[]> args) {
        String sql="UPDATE t_book SET ustatus=?, username=? WHERE user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(ints);
    }

    @Override
    public void batchDeleteBook(List<Object[]> args) {
        String sql="DELETE FROM t_book WHERE user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(ints);
    }
}
