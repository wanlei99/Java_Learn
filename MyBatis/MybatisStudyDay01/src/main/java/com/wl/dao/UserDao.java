package com.wl.dao;

import com.wl.pojo.User;

import java.util.List;

/**
 * user 持久层
 * @author 98710
 */
public interface UserDao {
	List<User> getUserList();
}
