package com.travelers.user.subscribe;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelers.user.subscribe.bo.SubscribeBO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("user/subscribe")
public class SubscribeRestController {
	
	@Autowired
	private SubscribeBO subscribeBO;
	
	@GetMapping("/addSubscribeUser") 
	public Map<String, String> addSubscribeUser(HttpServletRequest request
												, @RequestParam("userCd") int userCd
												, @RequestParam("userName") String userName){
		Map<String, String> map = new HashMap<>();
		HttpSession session = request.getSession();
		
		int thisUserCd = (Integer)session.getAttribute("userCd");
		String thisUserName = (String)session.getAttribute("userName");
		
		int count = subscribeBO.addSubscribeUser(thisUserCd, userCd, thisUserName, userName);
		
		if(count == 1) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	

}
