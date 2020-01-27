package com.capstone.caps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.caps.WebUtils;
import com.capstone.caps.repository.UserRepository;

@Controller
public class AppController {
	
	@Autowired
	WebUtils webUtils;
	@Autowired
	
	private UserRepository userRepository;
	

	@GetMapping({"index","/"})

	public String index(Model model) {
		model.addAttribute("msg", "Welcome to Spring ");
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}
	@GetMapping("about")

	String about(Model model) {
		model.addAttribute("msg", "this is about us page");
		
		return "about";
	}
	
	@GetMapping("services")

	String services(Model model) {
		model.addAttribute("services", "this is services us page");
		
		return "services";
	}
	@GetMapping("name")

	String name(@RequestParam String id,Model model) {
		model.addAttribute("msg", id);
		
		return "index";
	}
	@GetMapping("getname-{id}")

	String getName(@PathVariable String id,Model model) {
		model.addAttribute("msg", id);
		
		return "index";
	}
//	@PostMapping("login")
//	public String login(@RequestParam String fname,@RequestParam String lname,Model model) {
//		model.addAttribute("msg","Last name:"+lname+"First name:"+fname);
//		return "index";
//				
//	}
	@PostMapping("sendemail")
	public String sendemail(Model model,@RequestParam String email 
			, @RequestParam String name 
			, @RequestParam String subject
			,@RequestParam String message ) {
		model.addAttribute("msg", "enail sent");
		webUtils.sendMail(email,"alex"+"hello","hello");
		return "services";
	}
	

	
	
}
