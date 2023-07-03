package com.learnSphere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.learnSphere.entity.*;
import com.learnSphere.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NavController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/createCourse")
	public String createCourse() {
		return "createCourse";
	}
	@GetMapping("/addLesson")
	public String addLesson() {
		return "addLesson";
	}
	@GetMapping("/student")
	public String student() {
		return "student";
	}
	@GetMapping("/trainer")
	public String trainer() {
		return "trainer";
	}
	@GetMapping("/mycourse")
	public String mycourse() {
		return "mycourse";
	}
	@GetMapping("/demolesson")
	public String demolesson() {
		return "demolesson";
	}
	@GetMapping("/myless")
	public String myless() {
		return "myless";
	}
	
	@GetMapping("/payment")
	public String order() {
		return "payment";
	}

	
	
	UserService us;
	
	public NavController(UserService us) {
		super();
		this.us = us;
	}
	@PostMapping("/register")
	public String addUser(@RequestParam("fname") String fname,
			               @RequestParam("lname") String lname,
			               @RequestParam("email") String email,
			               @RequestParam("password") String password,
			               @RequestParam("role") String role,
			               @RequestParam("mobile") String mobile) {
		boolean emailExists=us.checkEmail(email);
		if(emailExists==false) {
		Users u=new Users();
		u.setFname(fname);
		u.setLname(lname);
		u.setEmail(email);
		u.setPassword(password);
		u.setRole(role);
		u.setMobile(mobile);
		us.addUser(u);
		System.out.println("register succssefully!");
		return "redirect:/login";
		}
		else {
			System.out.println("user already exists!");
			return "redirect:/register";
		}
	}
	@PostMapping("/log")
	public String loginuser(@RequestParam("email") String email,@RequestParam("password") String password,Model model){
		if(true==us.checkEmail(email)) {
			Users er=us.getpass(email);
			model.addAttribute("use",er);
			System.out.println(er);
			boolean v=us.loginusers(email, password);
			   if(v==true) {
			   System.out.println("login successful");
			   boolean vv=us.validRole(email);
			       if(vv==true) {   
			    	   return "redirect:/student";
			         }else {
			        	 return "redirect:/trainer";
			        }
				}
	         else {
			System.out.println("incorrect password");
			return "redirect:/login";
			}
		}
		else {
			System.out.println("email not registerd");
			return "redirect:/login";
		}
		
	
	}

	
}
