package com.wl.demo1.service;

import com.wl.demo1.dao.UserService;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.08.26$
 * @Param 用户接口的实现类$
 * @return $
 */
public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("使用了添加方法！");
    }

    @Override
    public void delete() {
        System.out.println("使用了删除方法！");
    }

    @Override
    public void update() {
        System.out.println("使用的更新方法！");
    }

    @Override
    public void query() {
        System.out.println("使用了查询方法！");
    }
}
