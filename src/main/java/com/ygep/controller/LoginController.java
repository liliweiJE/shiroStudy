package com.ygep.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ygep.model.JL;
import com.ygep.model.user.User;
import com.ygep.service.user.RoleService;
import com.ygep.service.user.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginGet(User user,
			BindingResult bindingResult,RedirectAttributes redirectAttributes){
		//User user=userService.selectByKey(1);
		try {
			if(bindingResult.hasErrors()){
				return "login";
			}
			SecurityUtils.getSubject()
			.login(new UsernamePasswordToken(user.getUsername(), user.getPassword())); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPost(Model model){
		model.addAttribute("user",new User());
		return "login";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)    
	public String logout(RedirectAttributes redirectAttributes ){   
	        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息  
	        SecurityUtils.getSubject().logout();    
	        redirectAttributes.addFlashAttribute("message", "您已安全退出");    
	        return "login";  
	    }   
	
	@RequestMapping("/403")  
	public String unauthorizedRole(){  
	        return "403";  
	    }
	
	@RequestMapping("/jianli")
	@ResponseBody
	public void Jl(JL jl){
		System.out.println(jl.getName());
	}
}
