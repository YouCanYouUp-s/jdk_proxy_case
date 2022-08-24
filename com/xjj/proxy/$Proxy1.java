package com.xjj.proxy;

import com.xjj.proxy.handle.InvocationHandle;
import com.xjj.proxy.service.UserService;

import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 模拟JDK自动生成的代理对象 该代理对象是利用ASM直接产生二进制class文件 并将该字节码文件加载到jvm中创建代理对象
 * 可在jdk代理运行时 利用jad反编译代理对象的字节码 跟本案例结构相差无几
 */
class $Proxy1 implements UserService {
    private final InvocationHandle h;

    //根据增强需求 传入增强实现类
    public $Proxy1(InvocationHandle invocationHandle) {
        this.h = invocationHandle;
    }
    //静态初始化
    static Method login;
    static Method bar;
    static {
        try {
            login = UserService.class.getMethod("login", String.class,String.class);
            bar = UserService.class.getMethod("bar");
        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodError(e.getMessage());
        }
    }

    @Override
    public boolean login(String uname,String pwd) {
        try {
            //h.invoke 利用invocationHandel的实现类做增强处理 实现类中实现了invoke方法
            return (boolean) h.invoke(this, login,new Object[]{uname,pwd});
        }catch (RuntimeException | Error  e){//运行时异常
            throw e;
        }catch (Throwable throwable){//检查异常不能直接抛出 需要转为运行时异常抛出 UndeclaredThrowableException继承了RuntimeException
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void bar() {
        try {
            h.invoke(this, bar, null);
        }catch (RuntimeException | Error  e){
            throw e;
        }catch (Throwable throwable){
            throw new UndeclaredThrowableException(throwable);
        }
    }
}
