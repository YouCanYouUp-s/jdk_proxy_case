package com.xjj.proxy;

import com.xjj.proxy.handle.UserLogHandle;
import com.xjj.proxy.handle.TransactionHandle;
import com.xjj.proxy.service.UserServiceImpl;

public class App {
    public static void main(String[] args) {
        //需要被增强的目标对象
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        //模拟spring事务注解aop实现原理
        $Proxy1 proxy1 = new $Proxy1(new TransactionHandle(userServiceImpl));
        proxy1.bar();
        System.out.println("-------------------------------------");

        //模拟aop日志记录场景实现
        $Proxy1 proxy2 = new $Proxy1(new UserLogHandle(userServiceImpl));
        boolean loginResult = proxy2.login("admin", "admin");
        System.out.println(loginResult);
    }
}
