package com.ygep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ygep.model.user.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/init")
	public String selectById(Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		model.addAttribute("user",user);
		return "index";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public void addUser(){
		System.out.println("have add role");
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public void del(Integer id){
		System.out.println("have del role");
	}

	@RequestMapping("/edit")
	@ResponseBody
	public void edit(Integer id){
		System.out.println("have edit role");
	}
}
