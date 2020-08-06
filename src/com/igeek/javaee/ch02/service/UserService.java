package com.igeek.javaee.ch02.service;

import com.igeek.javaee.ch02.dao.UserDao;
import com.igeek.javaee.ch02.entity.User;

/**
 * 关于用的业务逻辑
 */
public class UserService {

    private UserDao dao = new UserDao();

    //登录 login
    public User login(String username, String password){
        //结合各种业务逻辑（判断是否激活、是否审核通过）
        User user = dao.selectUserByNameAndPwd(username, password);
        return user;
    }


    //注册

    //修改

    //删除

    //通过id查看

    //通过查看所有（条件查询+分页查询）

}
