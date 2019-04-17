package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * 
 * @author ct
 *处理器类
 *1.不用实现Controller接口
 *2.方法名不做要求，可以是ModelAndView，也可以是String
 *3.可以添加多个方法
 *4.使用@Controller
 *5.可以在方法前或者类前添加@RequestMapping（相当于HandlerMapping）
 */
@Controller
//@RequestMapping("/demo")
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("hello()");
		return "hello";
	}
	
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		System.out.println("toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request) {
		System.out.println("login()");
		
		String adminCode = request.getParameter("adminCode");
		System.out.println("adminCode:"+adminCode);
		
		return "index";
	}
	@RequestMapping("/lohin2.do")
	
	/*
	 * 
	 * 
	 */
	
	public String login2(String adminCode,@RequestParam("pwd") String password) {
		
		System.out.println("adminCode:"+adminCode);
		System.out.println("pwd:"+password);
		return "index";
	}
	
	
}
