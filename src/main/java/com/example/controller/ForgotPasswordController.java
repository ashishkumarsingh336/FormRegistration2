package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.ForgotPwdDTO;
import com.example.service.UserRegistrationService;

@Controller
public class ForgotPasswordController {
	@Autowired
	private UserRegistrationService userRegService;
     
	/**
	 * Display Forgot Password Form 
	 * 
	 */
	
	@RequestMapping(value = "/forgotPwd")
	public String displayForgotPwd(Model model) {

		ForgotPwdDTO dto = new ForgotPwdDTO();
		model.addAttribute("forgotPass", dto);

		return "forgotPassword";

	}
     
	
	/**
	 * 
	 * Get Password back through email
	 * 
	 */
	@RequestMapping(value = "/forgotPw", method = RequestMethod.POST)
	public String recoverPass(@ModelAttribute("forgotPass") ForgotPwdDTO dto, Model model) throws Exception {
		
		String str = userRegService.fetchEmail(dto);

		model.addAttribute("result", str);

		return "forgotPassword";

	}

}
