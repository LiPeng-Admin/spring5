package com.atguigu.service;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/15 22:57
 */
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("add() called");
        userDao.update();

    }
}
