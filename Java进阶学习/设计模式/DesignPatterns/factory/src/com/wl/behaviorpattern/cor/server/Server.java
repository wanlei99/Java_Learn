package com.wl.behaviorpattern.cor.server;

import com.wl.behaviorpattern.cor.middleware.Middleware;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WL
 * @description: 授权目标
 * @date 2021/9/16 15:47
 */
public class Server {
	private Map<String , String> users = new HashMap<>();
	private Middleware middleware;

	/**
	 * 客户端向服务器传递一个对象链。这提高了灵活性
	 * 使测试服务器类更容易。在所有其他检查之后运行它的检查。
	 * @author wl
	 * @date 2021/9/16 15:49
	 * @param middleware
	 */
	public void setMiddleware(Middleware middleware) {
		this.middleware = middleware;
	}

	/**
	 *服务器从客户端获取电子邮件和密码并发送授权
	 *请求链。
	 * @author wl
	 * @date 2021/9/16 15:51
	 * @param email
	 * @param password
	 * @return boolean
	 */
	public boolean login(String email, String password){
		if (middleware.check(email, password)){
			System.out.println("授权成功!");
			return true;
		}
		return false;
	}

	public void register(String email, String password){
		users.put(email, password);
	}

	public boolean hasEmail(String email) {
		return users.containsKey(email);
	}

	public boolean isValidPassword(String email, String password){
		return users.get(email).equals(password);
	}
}
