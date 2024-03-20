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
import com.travelers.user.dto.UserDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
	
	@PostMapping("/signUp")
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
	
	@GetMapping("/isDuplicateId")
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
	
	@PostMapping("/signIn")
	public Map<String, String> signIn(
			@RequestParam("loginId") String loginId
			,@RequestParam("password") String password
			, HttpServletRequest request){
		
		
		UserDTO thisUserDTO = userBO.loginUser(loginId, password); 
		
		//System.out.println(thisUserDTO);
		
		Map<String, String> map = new HashMap<>();
		
		if(thisUserDTO != null) {
			map.put("result", "success");
			
			HttpSession session = request.getSession();
			
			session.setAttribute("userCd", thisUserDTO.getUserCd());
			session.setAttribute("userLoginId", thisUserDTO.getLoginId());
			session.setAttribute("userName", thisUserDTO.getUserName());
		}
		else {
			map.put("result", "fail");
		}
		
		return map;
	}

	
	

}
