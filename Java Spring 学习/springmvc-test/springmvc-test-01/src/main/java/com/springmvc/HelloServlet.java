package com.springmvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author WL
 * @description:
 * @date 2021/9/22 13:58
 */
public class HelloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取参数
		String method = req.getParameter("method");
		if (method.equals("add")){
			req.getSession().setAttribute("msg","执行了add方法");
		}
		if (method.equals("delete")){
			req.getSession().setAttribute("msg","执行了delete方法");
		}
		//业务逻辑
		//业务视图
		req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req,resp);
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
