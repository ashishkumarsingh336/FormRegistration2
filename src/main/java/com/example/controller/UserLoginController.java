package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.UserLoginDTO;
import com.example.service.UserRegistrationService;

@Controller
public class UserLoginController {
	@Autowired
	private UserRegistrationService userRegService;
	
	/**
	 * Display form page
	 * 
	 */
	@RequestMapping(value= {"/","/login"},method=RequestMethod.GET)
	public String displayFormPage(@ModelAttribute("login")UserLoginDTO dto,Model model) {
		
		model.addAttribute("login", dto);
		
		return "userLoginForm";
		
	}
	/**
	 * Login form page using Email and Password
	 * 
	 */
	@RequestMapping(value="/loginAccount",method=RequestMethod.POST)
	public String lognFormPage(@ModelAttribute("login")UserLoginDTO dto,Model model) {
		
		String str = userRegService.findEmailAndPwd(dto);
		model.addAttribute("string", str);
		
		return "userLoginForm";
		
	}
	
	

}
