package com.webvidhi.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebApplication {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String index(Model map) {
		
		map.addAttribute("message", "INDEX");
		return "index";
		
	}

}
