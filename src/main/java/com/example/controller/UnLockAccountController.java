package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.UnlockAccountDTO;
import com.example.service.UserRegistrationService;

@Controller
public class UnLockAccountController {

	@Autowired
	private UserRegistrationService userRegService;

	@RequestMapping(value = "/unlockAcc", method = RequestMethod.GET)
	public String displayUnclockAccount(HttpServletRequest req, Model model) {
		UnlockAccountDTO dto = new UnlockAccountDTO();
		String email = req.getParameter("email");
		dto.setEmail(email);
		model.addAttribute("unlockAccount", dto);

		return "unlockAccount";
		
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String handleSumitBtn(@ModelAttribute("unlockAccount") UnlockAccountDTO dto, RedirectAttributes redirect) {
		boolean flag = userRegService.fetchEmailAndPwd(dto);
		if (flag == true)
			redirect.addFlashAttribute("MSG", "your account is unlocked.Please login");
		else
			redirect.addFlashAttribute("MSG1", "Dear user your account is locked.Please try again.... ");

		return "redirect:udatedSuccessfully";

	}
	@RequestMapping(value="/udatedSuccessfully",method=RequestMethod.GET)
   public String validatUnlock(Model model) {
	         
		UnlockAccountDTO dto=new UnlockAccountDTO();
		model.addAttribute("unlockAccount", dto);
	   
	return "unlockAccount";
	   
   }
}
