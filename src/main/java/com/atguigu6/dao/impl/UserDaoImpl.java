package com.atguigu6.dao.impl;

import com.atguigu6.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/24 16:20
 */
@Repository
public class UserDaoImpl implements UserDao {
    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //mary收到lucy 转账的100
    @Override
    public void addMoney() {
        String sql = "UPDATE t_account SET money=money+? WHERE username=?";
        jdbcTemplate.update(sql, 100, "mary");

    }

    //lucy转账100给mary
    @Override
    public void reduceMoney() {
        String sql = "UPDATE t_account SET money=money-? WHERE username=?";
        jdbcTemplate.update(sql, 100, "lucy");

    }
}
