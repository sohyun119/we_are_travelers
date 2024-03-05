package com.travelers.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelers.user.bo.UserBO;

@RestController
@RequestMapping("user")
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
	
	@PostMapping("/singUp")
	public Map<String, String> signUp(
			@RequestParam("email") String email
			, @RequestParam("name") String name
			, @RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			){
		
		int count = userBO.addUser(email, name, loginId, password);
		
		Map<String, String> map = new HashMap<>();
		
		if(count == 1) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	@GetMapping("isDuplicateId")
	public Map<String, String> isDuplicate(
			@RequestParam("loginId") String loginId
			){
		Map<String, String> map = new HashMap<>();
		
		if(userBO.isDuplicate(loginId)) {
			map.put("is_duplicate", "true");
		}else {
			map.put("is_duplicate", "false");
		}
		
		return map;
	}
	
	
	
	

}
