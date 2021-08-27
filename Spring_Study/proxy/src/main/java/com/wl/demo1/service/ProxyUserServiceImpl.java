package com.wl.demo1.service;

import com.wl.demo1.dao.UserService;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.08.26$
 * @Param 代理模式的实现类$
 * @return $
 */
public class ProxyUserServiceImpl implements UserService {
    private UserService userService;

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }
    public void log(String msg) {
        System.out.println("【DeBug】调用了"+msg+"方法");
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
