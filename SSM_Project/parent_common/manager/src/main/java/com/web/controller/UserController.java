package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author WL
 * @description: 用户控制器
 * @date 2021/9/17 13:48
 */
@Controller
@RequestMapping("user")
public class UserController {
	public String login(){
		System.out.println("登录");
		return null;
	}
}
