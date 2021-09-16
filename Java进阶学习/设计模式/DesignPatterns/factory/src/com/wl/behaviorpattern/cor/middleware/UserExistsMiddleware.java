package com.wl.behaviorpattern.cor.middleware;

import com.wl.behaviorpattern.cor.server.Server;

/**
 * @author WL
 * @description: 检查用户的登录信息
 * @date 2021/9/16 15:55
 */
public class UserExistsMiddleware extends Middleware{

	private Server server;

	public UserExistsMiddleware(Server server){
		this.server = server;
	}

	@Override
	public boolean check(String email, String password) {
		if (!server.hasEmail(email)){
			System.out.println("这个账号没有注册！");
			return false;
		}
		if (!server.isValidPassword(email,password)){
			System.out.println("密码错误！");
			return false;
		}
		return checkNext(email, password);
	}
}
