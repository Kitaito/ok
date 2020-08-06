package com.igeek.javaee.ch02.dao;

import com.igeek.javaee.ch02.entity.User;

/**
 * 为用户提供数据交互
 */
public class UserDao extends BaseDao<User> {

    //通过用户名和密码查询用户信息
    public User selectUserByNameAndPwd(String name,String pwd){
        User user = this.getBean(User.class, "select * from t_user where name = ? and pwd = ?", name, pwd);
        return user;
    }

}
