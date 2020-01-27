package com.capstone.caps.controller;

import com.capstone.caps.model.Event;
import com.capstone.caps.model.User;
import com.capstone.caps.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.capstone.caps.WebUtils;
import com.capstone.caps.repository.UserRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {

	@Autowired
	WebUtils webUtils;
	@Autowired

	private UserRepository userRepository;
	private EventRepository eventRepository;


	@GetMapping({"index", "/"})

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
	String name(@RequestParam String id, Model model) {
		model.addAttribute("msg", id);

		return "index";
	}

	@GetMapping("getname-{id}")
	String getName(@PathVariable String id, Model model) {
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
	public String sendemail(Model model, @RequestParam String email
			, @RequestParam String name
			, @RequestParam String subject
			, @RequestParam String message) {
		model.addAttribute("msg", "enail sent");
		webUtils.sendMail(email, "alex" + "hello", "hello");
		return "services";
	}

	@PostMapping("createevent")
	public String createevent(@ModelAttribute Event event,Model model) {
		eventRepository.save(event);
		model.addAttribute("event","Event was succesfully created , thanks a lot!");
		return "profile";
	}
	@GetMapping("eventform")
	public String eventform(Event event){

		return "eventform";
	}
}