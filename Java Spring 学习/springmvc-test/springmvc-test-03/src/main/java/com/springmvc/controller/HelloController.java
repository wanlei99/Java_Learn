package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author WL
 * @description:
 * @date 2021/9/22 15:11
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping("/h1")
	public String helloSpring(){
		return "hello";
	}
}
