package com.travelers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@GetMapping("/signUpView")
	public String signUpView() {
		return "user/signUpView";
	}
	
	@GetMapping("/signInView")
	public String signInView() {
		return "user/signInView";
	}
	
	@GetMapping("/signOut")
	public String signOut(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("userCd");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		
		return "redirect:/user/signInView";
	}

}
