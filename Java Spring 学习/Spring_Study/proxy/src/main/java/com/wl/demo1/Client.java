package com.wl.demo1;

import com.wl.demo1.dao.UserService;
import com.wl.demo1.service.ProxyUserServiceImpl;
import com.wl.demo1.service.UserServiceImpl;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.08.26$
 * @Param 静态代理测试类$
 * @return $
 */
public class Client {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ProxyUserServiceImpl proxyUserService = new ProxyUserServiceImpl();
        //为代理设置代理对象
        proxyUserService.setUserService(userService);
        proxyUserService.add();
    }
}
