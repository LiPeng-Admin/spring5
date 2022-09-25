package com.atguigu6.service;

import com.atguigu6.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/24 16:17
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
public class UserService {
    //注入dao
    @Autowired
    private UserDao userDao;

    public void accountMoney() {
        //lucy少钱的功能
        userDao.reduceMoney();
        //模拟异常
//        int i=10/0;

        //mary多钱的功能
        userDao.addMoney();

    }
}
