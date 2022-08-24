package com.xjj.proxy.handle;

import java.lang.reflect.Method;

/**
 * 增强实现接口
 */
public interface InvocationHandle {
    /**
     *
     * @param proxy 代理类
     * @param method 方法类型
     * @param args1 方法参数
     * @return Object
     * @throws Throwable
     */
    Object invoke(Object proxy, Method method, Object[] args1) throws Throwable;
}
