package com.iocStudy.service.impl;

import com.iocStudy.dao.UserDao;
import com.iocStudy.dao.impl.MySqlDaoImpl;
import com.iocStudy.dao.impl.UserDaoImpl;
import com.iocStudy.service.UserService;
import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.8.13$
 * @Param 业务实现$
 * @return $
 */
public class UserServiceImpl implements UserService {
   private UserDao userDao;
   @Setter
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
    public void test(){
        System.out.println("test");
    }
}
