package com.igeek.javaee.ch04.items.service;

import com.igeek.javaee.ch04.items.dao.UserDao;
import com.igeek.javaee.ch04.items.entity.User;

public class UserService {

    private UserDao dao = new UserDao();

    //登录
    public User login(String username , String password){
        User user = dao.selectUserByNameAndAddr(username, password);
        return user;
    }

}
