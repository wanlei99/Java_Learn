package com.wl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author WL
 * @description:
 * @date 2021/9/22 13:33
 */
@Controller
public class UserController {
	@RequestMapping("/login")
	public String toLoginPage(Model model){
		model.addAttribute("msg","Hello SpringMVC 注解");
		return "login";
	}
}
