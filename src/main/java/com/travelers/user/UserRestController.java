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
		
		// 일단 여기를 고쳐서 thisUser 값이 null이 안되게 한 다음
		// postCreate jsp 화면 에서 location lat lng 값이 전달 안되는 이유를 찾아야함 
		
		UserDTO thisUser = userBO.loginUser(loginId, password); 
		
		
		System.out.println("userCd : "+thisUser.getUserCd() + ", userName : "+thisUser.getUserName());
		
		Map<String, String> map = new HashMap<>();
		
		if(thisUser != null) {
			map.put("result", "success");
			
			HttpSession session = request.getSession();
			
			session.setAttribute("userCd", thisUser.getUserCd());
			session.setAttribute("userLoginId", thisUser.getLoginId());
			session.setAttribute("userName", thisUser.getUserName());
		}
		else {
			map.put("result", "fail");
		}
		
		return map;
	}

	
	

}
