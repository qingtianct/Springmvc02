package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Model.AdminParam;

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
	@RequestMapping("/login2.do")
	
	/*
	 * 
	 * 
	 */
	
	public String login2(String adminCode,@RequestParam("pwd") String password) {
		
		System.out.println("adminCode:"+adminCode);
		System.out.println("pwd:"+password);
		return "index";
	}
	
//	页面传值三种方式
//	方式1.request
	@RequestMapping("/login4.do")
	public String login4(AdminParam ap,HttpServletRequest request) {
		System.out.println("login4()");
		
		String adminCode = ap.getAdminCode();
		request.setAttribute("adminCode",adminCode);
		
		
		return "index";
	}
	
//	方式2.ModelAndView
	@RequestMapping("/login5.do")
	public ModelAndView login5(AdminParam ap) {
		System.out.println("login5()");
		
		String adminCode = ap.getAdminCode();
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code",adminCode);
		ModelAndView mav = new ModelAndView("index",data);
		return mav;
	}
//	方式3.ModelMap
	@RequestMapping("/login6.do")
	public String login6(AdminParam ap,ModelMap mm) {
		System.out.println("login6()");
		
		String adminCode = ap.getAdminCode();
		mm.addAttribute("adminCode",adminCode);
		
		return "index";
	}
	
}
