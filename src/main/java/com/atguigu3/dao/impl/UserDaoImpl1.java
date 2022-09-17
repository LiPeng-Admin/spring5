package com.atguigu3.dao.impl;

import com.atguigu3.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/17 20:54
 */
@Repository(value = "userDaoImpl1")
public class UserDaoImpl1 implements UserDao {
    @Override
    public void update() {
        System.out.println("userdao update....");
    }
}
