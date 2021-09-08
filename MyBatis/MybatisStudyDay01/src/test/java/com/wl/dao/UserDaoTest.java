package com.wl.dao;

import com.wl.pojo.User;
import com.wl.utils.MybatisUtil;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class UserDaoTest extends TestCase {

	public void testGetUserList(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		List<User> userList = userDao.getUserList();
		for (User user : userList) {
			System.out.println(user.toString());
		}
		sqlSession.close();
	}
}