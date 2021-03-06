package com.capston.caps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capston.caps.WebUtils;
import com.capston.caps.model.Users;
import com.capston.caps.repository.UserRepository;
import com.capston.caps.service.UserService;

@Controller
public class AppController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	WebUtils webUtils;
	
	@GetMapping({"index","/"})
	public String index(Model model) {	
	// model.addAttribute("msg", "Welcome to spring ");
	 model.addAttribute("users", userService.findAll());
	return "index";		
	}
	
	@GetMapping("about")
	//@ResponseBody()
	public String about(Model model) {
	model.addAttribute("msg", "this is about us page");
	return "about";		
	}
	
	@GetMapping("service")
	public String service(Model model) {
	model.addAttribute("msg", "Get in touch with us by filling");
	return "services";		
	}
	
	@PostMapping("sendemail")
	public String sendemail(Model model, @RequestParam String email,
							@RequestParam String name,
							@RequestParam String subject,
							@RequestParam String message) {
		
		try {
			webUtils.sendMail("oleksandrhuliaitest@gmail.com",
							  message+ " From "+name, subject);
			model.addAttribute("msg", "email sent");
		} catch (Exception e) {
			model.addAttribute("msg", e);
		}
		return "services";
	}
	
	@GetMapping("name")
	public String name(@RequestParam int id, Model model) {
	model.addAttribute("msg", id);
	return "index";		
	}
	
	@GetMapping("getname-{id}")
	public String getname(@PathVariable String id, Model model) {
	model.addAttribute("msg", id);
	return "index";		
	}
	
	@PostMapping("whatisyouname")
	public String login(@RequestParam String lname,
						@RequestParam String fname, Model model) {
		model.addAttribute("msg", "Last Name "+ lname+" first name "+fname);
		
	return "index";		
	}
		
	 
	
	

}
