package com.xjj.proxy.handle;

import com.xjj.proxy.service.UserServiceImpl;

import java.lang.reflect.Method;

/**
 * 模拟开启事务-@transaction实现原理 aop代理
 */
public class TransactionHandle implements InvocationHandle {
    private final UserServiceImpl userServiceImpl;

    public TransactionHandle(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args1) throws Throwable {
        System.out.println("开启事务begin");
        //****反射调用 method.invoke() 指定一个方法在目标实例上执行 UserServiceImpl 代理目标对象， args1 方法参数
        Object result = method.invoke(userServiceImpl, args1);
        System.out.println("commit");
        return result;
    }
}
