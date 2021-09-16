package com.wl.behaviorpattern.cor;

import com.wl.behaviorpattern.cor.middleware.Middleware;
import com.wl.behaviorpattern.cor.middleware.RoleCheckMiddleware;
import com.wl.behaviorpattern.cor.middleware.ThrottlingMiddleware;
import com.wl.behaviorpattern.cor.middleware.UserExistsMiddleware;
import com.wl.behaviorpattern.cor.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author WL
 * @description: 测试
 * @date 2021/9/16 15:59
 */
public class Demo {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static Server server;

	private static void init(){
		server = new Server();
		server.register("admin@example.com","admin");
		server.register("user@example.com", "user");
		//所有检查都是链接的客户端可以使用相同的代码构建各种链组件。
		Middleware middleware = new ThrottlingMiddleware(2);
		middleware.linkWith(new UserExistsMiddleware(server)).linkWith(new RoleCheckMiddleware());
		server.setMiddleware(middleware);
	}

	public static void main(String[] args) throws IOException {
		init();

		boolean success;
		do {
			System.out.println("输入邮箱：");
			String email = reader.readLine();
			System.out.println("输入密码：");
			String password = reader.readLine();
			success = server.login(email,password);
		} while (!success);
	}
}
