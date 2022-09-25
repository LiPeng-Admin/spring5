package com.atguigu4.dao.impl;

import com.atguigu4.dao.UserDao;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/18 10:33
 */
public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
