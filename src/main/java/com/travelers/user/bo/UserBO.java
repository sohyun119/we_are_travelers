package com.travelers.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelers.user.dao.UserDAO;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	public int addUser(String email, String name, String loginId, String password) {
		return userDAO.insertUser(email, name, loginId, password);
	}
	
	public boolean isDuplicate(String loginId) {
		
		if(userDAO.selectDuplicate(loginId) == 1) {
			return true;
		}else {
			return false;
		}
	}
	

}
