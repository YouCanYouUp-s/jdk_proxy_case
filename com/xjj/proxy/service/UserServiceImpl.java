package com.xjj.proxy.service;


/**
 * 代理目标类
 */
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String uname,String pwd) {
        System.out.println("执行login()");
        return "admin".equals(uname) && "admin".equals(pwd);
    }

    @Override
    public void bar() {
        System.out.println("执行bar()");
    }
}
