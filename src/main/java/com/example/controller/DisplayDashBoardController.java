package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DisplayDashBoardController {
    
     /**
      * Display dashBoard message
      * 
      */
     @RequestMapping(value="/dashBoard",method=RequestMethod.GET)
     public String displayDashBoard(Model model) {
		
    	 model.addAttribute("Msg","Hi dear,Welcome to tek leads");
    	 
    	 return "tekLeads";
     }
}
