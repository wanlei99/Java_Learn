package com.wl.behaviorpattern.cor.middleware;

/**
 * @author WL
 * @description: 检查用户角色
 * @date 2021/9/16 15:44
 */
public class RoleCheckMiddleware extends Middleware{
	@Override
	public boolean check(String email, String password) {
		if (email.equals("admin@example.com")){
			System.out.println("Hello admin!");
			return true;
		}
		System.out.println("Hello ,User!");
		return checkNext(email, password);
	}
}
