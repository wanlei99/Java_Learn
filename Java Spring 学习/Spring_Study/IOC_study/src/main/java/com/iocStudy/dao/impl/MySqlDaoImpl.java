package com.iocStudy.dao.impl;

import com.iocStudy.dao.UserDao;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ $
 * @Param $
 * @return $
 */
public class MySqlDaoImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("mysql获取用户数据");
    }
}
