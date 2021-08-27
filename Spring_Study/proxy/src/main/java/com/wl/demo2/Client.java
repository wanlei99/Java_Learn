package com.wl.demo2;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.08.27$
 * @Param 动态代理测试类$
 * @return $
 */
public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setRent(host);
        Rent proxy = (Rent) pih.getProxy();
        proxy.rent();
        proxy.buyHouse();
    }
}
