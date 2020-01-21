package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.UserRegDTO;
import com.example.service.UserRegistrationService;

@Controller
public class UserRegistrationController {
	@Autowired
	private UserRegistrationService userRegService;

	/**
	 * 
	 * Display Registration Form Page
	 * 
	 */
	@RequestMapping(value = "/signup")
	public String displayFormPage(Model model) {
		UserRegDTO dto = new UserRegDTO();
		model.addAttribute("userRegistration", dto);

		return "registrationForm";

	}

	@RequestMapping(value = "/saveRecord", method = RequestMethod.POST)
	public String handleSubmitBtn(@ModelAttribute("userRegistration")UserRegDTO dto,RedirectAttributes redirectAttribute) throws Exception {
		
		
		boolean save = false;
		if(dto.getEmail()!=""||dto.getFName()!=""||dto.getLName()!=""||dto.getPhNo()!=null||dto.getDob()!=""||dto.getGender()!=""||dto.getCity()!=""||dto.getState()!=""||dto.getCountry()!="") {
		save = userRegService.save(dto);
		}
		System.out.println(save);
		if (save)
			redirectAttribute.addFlashAttribute("sMsg", "Record saved Successfully");
		else
			redirectAttribute.addFlashAttribute("sMsg1", "Record not saved.Please enter all details.....");

		return "redirect:/saveRecordSuccessfully";

	}

	/**
	 * 
	 * Solved double Posting Problem
	 */
	@RequestMapping(value = "/saveRecordSuccessfully", method = RequestMethod.GET)
	public String saveFormDetails(Model model) {

		UserRegDTO dto = new UserRegDTO();
		model.addAttribute("userRegistration", dto);

		return "registrationForm";

	}
	
	

}
