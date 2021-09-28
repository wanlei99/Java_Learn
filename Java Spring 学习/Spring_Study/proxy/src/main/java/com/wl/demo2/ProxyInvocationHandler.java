package com.wl.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.08.27$
 * @Param 代理类$
 * @return $
 */
public class ProxyInvocationHandler implements InvocationHandler {
    private Object rent;
    public void setRent(Object rent) {
        this.rent = rent;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object result = method.invoke(rent,args);
        return result;
    }
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);
    }
    public void log(String name){
        System.out.println("调用了"+name+"方法");
    }
}
