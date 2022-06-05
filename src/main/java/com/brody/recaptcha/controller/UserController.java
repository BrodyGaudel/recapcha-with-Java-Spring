package com.brody.recaptcha.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brody.recaptcha.entity.User;
import com.brody.recaptcha.service.UserService;
import com.brody.recaptcha.validator.CaptchaValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;

	private CaptchaValidator captchaValidator;

	public UserController(UserService userService, CaptchaValidator captchaValidator) {
		
		this.userService = userService;
		this.captchaValidator = captchaValidator;
	}
	
	@GetMapping("/register")
	public String registerUser(Model model) {
		
		model.addAttribute("user", new User());
		return "registerUser";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user, Model model, @RequestParam("g-recaptcha-response") String captcha) {
		
		if(captchaValidator.isValidCaptcha(captcha)) {
			Integer id = userService.createUser(user);
			model.addAttribute("message", "User with id : '"+id+"' Saved Successfully !");
			model.addAttribute("user", new User());
		} else{
			model.addAttribute("message", "Please validate captcha first");
		}
		
		return "registerUser";
	}
	
	@GetMapping("/all")
	public String getAllUsers(Model model) {
		List<User> users= userService.getAllUsers();
		model.addAttribute("list", users);
		return "listUsers";
	}
}
