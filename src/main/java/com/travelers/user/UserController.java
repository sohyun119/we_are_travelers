package com.travelers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
	
	
	@GetMapping("/signUpView")
	public String signUpView() {
		return "user/signUpView";
	}
	
	@GetMapping("/signInView")
	public String signInView() {
		return "user/signInView";
	}

}
