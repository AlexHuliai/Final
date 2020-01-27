package com.capstone.caps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capstone.caps.model.User;
import com.capstone.caps.repository.UserRepository;
import com.capstone.caps.service.UserService;
import com.capstone.caps.validation.DataValidation;

@Controller
@SessionAttributes("loggedInUser")
public class LoginController {
	
	private UserService userService;

	private UserRepository userRepository;
	@Autowired
	private DataValidation dataValidation;
	
	
	@Autowired
	public LoginController(UserRepository userRepository,UserService userService) {
		super();
		this.userRepository = userRepository;
		this.userService = userService;
	}
	
	
	@ModelAttribute("user")
	
	User user() {
		return new User();
	}
	@GetMapping("register")
	public String register(Model model) {
		model.addAttribute("msg", "Register");
		model.addAttribute("user",new User());
	model.addAttribute("hidden", "");
	model.addAttribute("action", "register");
	//	model.addAttribute("user", new User());
		return "register";
	}
	@PostMapping("search")
	public String search(@RequestParam String name,Model model) {
		model.addAttribute("msg",userService.findByLastName(name).size()+" users found");
		model.addAttribute("users",userService.findByLastName(name));
		
		
		return "users";
	}
	
	@PostMapping("register")
	public String register(@ModelAttribute User user, 
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
	userRepository.save(user);
	    redirect.addFlashAttribute("success", "User "+user.getFname()+" saved");

	} catch (Exception e) {
	// TODO Auto-generated catch block
	//e.printStackTrace();
	}
	    return "redirect:/users";	
	}
	@GetMapping("delete")
	public String deleteUser(@RequestParam long id,RedirectAttributes redirect) {
		userService.delete(id);
		redirect.addFlashAttribute("petro","Delete Success");
		return "redirect:/users";
	}
	@GetMapping("update")
	public String updateUser(@RequestParam long id,Model model) {
		userRepository.findById(id);
		model.addAttribute("petro", "Update");
		model.addAttribute("user", userRepository.findById(id));
model.addAttribute("hidden", "hidden");
model.addAttribute("action", "updateUser");
		return "register";
	}
	@GetMapping("login")
	public String login(Model model) {
		model.addAttribute("msg","Login");
		return "login";
	}
	@GetMapping("profile")
	public String profile(Model model) {
		model.addAttribute("msg", "Welcome back");
		return "profile";
	}
	@GetMapping("users")
	public String users(Model model) {
		model.addAttribute("msg","Login");
		model.addAttribute("users",userRepository.findAll());
		return "users";
	}
	@PostMapping("login")
	public String signin(@RequestParam String email,
			@RequestParam String password,
			Model model) {
		User user = userRepository.findByEmail(email);
		if(user!=null && password.equals(user.getPassword())) {
			model.addAttribute("msg","Welcome back "+user.getFname());
			model.addAttribute("loggedInUser", user);
		}
		else {
			model.addAttribute("error", "Invalid Credentials");
			return "login";
		}
		
		return "profile";
	}
	@PostMapping("updateUser")
	public String update(@ModelAttribute User user, 
	Model model, BindingResult result) {
	dataValidation.validateUpdate(user, result);
	if (result.hasErrors()) {
	model.addAttribute("error", "Required* fields");
	model.addAttribute("hidden", "hidden");
	model.addAttribute("action", "updateUser");
	        return "register";
	        }
	try {
		userService.update(user);
//	User usr= userRepository.findByEmail(user.getEmail());
//	usr.setFname(user.getFname());
//	usr.setLname(user.getLname());
//	usr.setPhone(user.getPhone());
//	userRepository.save(usr);	    
	model.addAttribute("success", "User "+user.getFname()+" Updated");
	} catch (Exception e) {
	// TODO Auto-generated catch block
	//e.printStackTrace();
	}
	return "redirect:/users";	
	}
	@GetMapping("logout")
	public String logout(Model model, WebRequest request, 
	SessionStatus status, RedirectAttributes redirect) {	
	status.setComplete();
	request.removeAttribute("loggedInUser", WebRequest.SCOPE_SESSION);
	redirect.addFlashAttribute("msg", "You have been signed out");
	return "redirect:/login";
	}
	
	@PostMapping("editrole")
	public String giverole(@RequestParam long id,String role,RedirectAttributes model) {
	User user = userRepository.findById(id).get();
	if(user!=null) {
	user.setRole(role);
	userRepository.save(user);
	model.addFlashAttribute("lego",user.getFname()+" is assigned to "+ role);
	}
	
	return "redirect:/users";
	}
	
	
	
	
	
	
	
	
	
}
