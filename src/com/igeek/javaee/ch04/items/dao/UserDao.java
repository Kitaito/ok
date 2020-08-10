package com.igeek.javaee.ch04.items.dao;

import com.igeek.javaee.ch04.items.entity.User;

public class UserDao extends BaseDao<User> {

    //通过姓名和地址查询用户信息
    public User selectUserByNameAndAddr(String username , String address){
        User user = this.getBean(User.class, "select * from user where username = ? and address = ?", username, address);
        return user;
    }

}
