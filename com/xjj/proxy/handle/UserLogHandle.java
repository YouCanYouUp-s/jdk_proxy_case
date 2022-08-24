package com.xjj.proxy.handle;

import com.xjj.proxy.service.UserServiceImpl;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 模拟记录用户日志 代理实现
 */
public class UserLogHandle implements InvocationHandle {
    private final UserServiceImpl userServiceImpl;

    public UserLogHandle(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args1) throws Throwable {
        Object result = method.invoke(userServiceImpl, args1);
        System.out.println("日志记录----"+method.getName()+"被调用;参数为："+ Arrays.toString(args1) +";返回结果为"+result);
        return result;
    }
}
