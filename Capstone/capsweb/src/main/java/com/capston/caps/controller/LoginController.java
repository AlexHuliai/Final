package com.capston.caps.controller;

import com.capston.caps.model.Event;


import com.capston.caps.repository.EventRepository;
import com.capston.caps.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capston.caps.WebUtils;
import com.capston.caps.model.Users;
import com.capston.caps.repository.UserRepository;
import com.capston.caps.service.UserService;
import com.capston.caps.validation.DataValidation;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Controller
@SessionAttributes("loggedInUser")
public class LoginController {
	
	//private UserRepository userRepository;
	
	private DataValidation dataValidation;
	
	private WebUtils webUtils;
	
	private UserService userService;
	@Autowired
	private EventService eventService;

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	public LoginController(UserService userService,
			//UserRepository userRepository, 
			DataValidation dataValidation, WebUtils webUtils) {
		super();
		//this.userRepository = userRepository;
		this.dataValidation = dataValidation;
		this.userService=userService;
		this.webUtils=webUtils;

	}

	@GetMapping("users")
	public String users(Model model) {
		
		model.addAttribute("users", userService.findAll());
		
		return "users";		
	}
	
	@GetMapping("login")
	public String login(Model model) {
		model.addAttribute("msg", "Login");
		return "login";		
	}
	
	@GetMapping("profile")
	public String profile(Model model) {
		model.addAttribute("msg", "Welcome back");
		return "profile";		
	}
	
	@PostMapping("login")
	public String signin(@RequestParam String email, WebRequest request,
						 @RequestParam String password, Model model) {
		try {
			Users user=userService.findByEmail(email).get();
			if(user !=null && password.equals(user.getPassword())) {
				model.addAttribute("msg", "Welcome "+email);
				model.addAttribute("loggedInUser", user);
				request.setAttribute("loggedInUser", user, WebRequest.SCOPE_SESSION);
			}else {
				model.addAttribute("error", "Invalid Credentials");
				return "login";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "profile";		
	}
	
	@PostMapping("search")
	public String search(@RequestParam String name, Model model) {
		
		model.addAttribute("msg", userService.findByLastname(name).size()+
				" user(s) found");
		model.addAttribute("users", userService.findByLastname(name));
		 
		return "users";		
	}
	
	@GetMapping("register")
	public String register(Model model) {
		
		model.addAttribute("msg", "Register");
		model.addAttribute("hidden", "");
		model.addAttribute("users", new Users());
		model.addAttribute("action", "register");
		
		return "register";		
	}
	
	@PostMapping("register")
	public String register(@ModelAttribute Users user, 
							Model model, BindingResult result,
							RedirectAttributes redirect) {
		
		try {
			dataValidation.validate(user, result);
			if (result.hasErrors()) {
				model.addAttribute("error", "Required* fields");
				model.addAttribute("hidden", "");
				model.addAttribute("action", "register");
		        return "register";
	        }
			user.setRole("USER");
			userService.save(user);
			webUtils.sendMail(user.getEmail(),"Thanks a lot for signing to RunningPal , happy work out","Thank you");
		    redirect.addFlashAttribute("success", "User "+user.getFname()+" saved");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
    	return "redirect:/users";		
	}
	
	
	@GetMapping("delete")
	public String deleteuser(@RequestParam int user_id,
			           RedirectAttributes redirect) {
		
		userService.delete(user_id);
		redirect.addFlashAttribute("success", "Delete Success");
		return "redirect:/users";		
	}
	
	@GetMapping("update")
	public String update(@RequestParam int user_id, Model model) {
		model.addAttribute("msg", "Update");
		model.addAttribute("users", userService.findById(user_id).get());
		model.addAttribute("hidden", "hidden");
		model.addAttribute("action", "updateUser");
		return "register";		
	}
	
	@PostMapping("updateUser")
	public String update(@ModelAttribute Users user, 
						RedirectAttributes model, Model mod,
						BindingResult result) {
		dataValidation.validateUpdate(user, result);
		if (result.hasErrors()) {
			mod.addAttribute("error", "Required* fields");
			mod.addAttribute("hidden", "hidden");
			mod.addAttribute("action", "updateUser");
	        return "register";
        }
		try {
			 userService.update(user);			   
			model.addFlashAttribute("success", "User "+user.getFname()+" Updated");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return "redirect:/users";		
	}
	
	@PostMapping("editprofile")
	public String editprofile(@ModelAttribute("user") Users user, 
						Model model) {
		
		try {
			Users usr= userService.findByEmail(user.getEmail()).get();
			usr.setFname(user.getFname());
			usr.setLname(user.getLname());
			usr.setPhone(user.getPhone());
			userService.save(usr);	
			model.addAttribute("loggedInUser", userService.findByEmail(user.getEmail()).get());
			
			model.addAttribute("success", " Updated success");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return "profile";		
	}
	
	@GetMapping("logout")
	public String logout(Model model, WebRequest request, 
			SessionStatus status) {	
		status.setComplete();
		request.removeAttribute("loggedInUser", WebRequest.SCOPE_SESSION);
		model.addAttribute("success", "You have been signed out");
		return "login";
	}
	
	@PostMapping("editrole")
	public String giverole(RedirectAttributes model, @RequestParam int user_id,
						   @RequestParam String role) {
	Users user= userService.findById(user_id).get();
	if(user !=null) {
		user.setRole(role);
		userService.save(user);
		model.addFlashAttribute("msg", user.getFname()+ " asigned role "+ role);
	}	
	return "redirect:/users";
	}
	
	@PostMapping("resetcode")
	public String resetcode(Model model, @RequestParam String email) {
	Users user= userService.findByEmail(email).get();
	if(user !=null) {
		//user.setCode(code);
		userService.save(user);
		webUtils.sendMail(email, "Please use this code"+888+" to reset password", "Password Reset");
		model.addAttribute("msg", "Check you email for seset instruction");
	}	
	return "resetpass";
	}
	
	@GetMapping("userprofile")
	public  String userprofile(@RequestParam int user_id,
				Model model) {
		
		try {
			model.addAttribute("profiles",userService.findById(user_id).get());
			webUtils.getFiles(model, user_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return "userprofiles";
	}
	
	@PostMapping("dropaline")
	public  String dropaline(@RequestParam String to,
							@RequestParam String from,
							@RequestParam String fromname,
							@RequestParam String message,
							RedirectAttributes model) {
		
		try {
			String msg=message+" Thanks. From "+fromname+" "+from;
			webUtils.sendMail(to, msg, "Hi Message");
			model.addFlashAttribute("msg", "Email sent");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return "redirect:/users";		
	}
	
	@ModelAttribute("profile")
	Users profile() {
		return new Users();
		
	}
	@GetMapping("event")
		public String eventform(Model model){
		model.addAttribute("events",new Event());

		return "event";
	}

	@PostMapping("event")
	public String create_event(Model model,@ModelAttribute Event event,RedirectAttributes redirect)
	{
		model.addAttribute("valera","Event was created");






		eventRepository.save(event);

		redirect.addFlashAttribute("success", "Event was saved");

		return "redirect:/profile";
	}
	@PostMapping("searchevent")
	public String searchevent(@RequestParam String street, Model model) {

		model.addAttribute("good", eventRepository.findByStreet(street).size()+
				" event(s) found");
		model.addAttribute("events", eventRepository.findAll());

		return "events";
	}
	@GetMapping("events")
	public String events(Model model,@SessionAttribute Users loggedInUser) {

		Users user = userService.findById(loggedInUser.getUser_id()).get();
		model.addAttribute("events", eventRepository.findAll());
		model.addAttribute("userEvents", user.getUserEvents());


		return "events";
	}
	@GetMapping("deleteevent")
	public String deleteevent(@RequestParam long id,
							 RedirectAttributes redirect) {

		eventService.delete(id);
		redirect.addFlashAttribute("lob", "Delete Success");
		return "redirect:/events";
	}
	@GetMapping("updateevent")
	public String updateevent(@RequestParam long id, Model model) {
		model.addAttribute("msg", "Update");
		model.addAttribute("events", eventService.findById(id).get());
		model.addAttribute("hidden", "hidden");
		model.addAttribute("action", "updateEvent");
		return "registerevents";
	}
	@PostMapping("updateEvent")
	public String updateevent(@ModelAttribute Event event,
						 RedirectAttributes model) {

			eventService.update(event);
			model.addFlashAttribute("success", "Event  Updated");

		return "redirect:/events";
	}

	@PostMapping("addUser")
	public String addusers(@RequestParam long event_id,@SessionAttribute Users loggedInUser, RedirectAttributes model){
		Event event =eventService.findById(event_id).get();
			if(event.getEventUsers()==null){
				event.setEventUsers(new ArrayList<>());
			}
			Users user = userService.findById(loggedInUser.getUser_id()).get();
			boolean userExists = event.getEventUsers().stream()
					.filter(usr -> usr.getUser_id() == user.getUser_id())
					.findFirst()
					.orElse(null) != null;
			if(!userExists) {
				event.getEventUsers().add(user);
				eventService.save(event);
			}
		model.addFlashAttribute("atend","Event was joined");

		return"redirect:/events";
	}
	@PostMapping("removeUser")
	public String removeusers(@RequestParam long event_id,@SessionAttribute Users loggedInUser, RedirectAttributes model){
		Event event1 =eventService.findById(event_id).get();
		if(event1.getEventUsers()==null){
			event1.setEventUsers(new ArrayList<>());
		}
		Users user = userService.findById(loggedInUser.getUser_id()).get();


		boolean userExists = event1.getEventUsers().stream()
				.filter(usr -> usr.getUser_id() != user.getUser_id())
				.findFirst()
				.orElse(null) != null;
		if(!userExists) {
			event1.getEventUsers().remove(user);

			eventService.save(event1);
		}
		model.addFlashAttribute("aeo","You left the event");

		return"redirect:/events";
	}
}
