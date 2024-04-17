package com.travelers.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelers.common.EncryptUtils;
import com.travelers.user.dao.UserDAO;
import com.travelers.user.dto.UserDTO;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	public int addUser(String email, String name, String loginId, String password) {
		return userDAO.insertUser(email, name, loginId, EncryptUtils.md5(password));
	}
	
	public boolean isDuplicate(String loginId) {
		
		if(userDAO.selectDuplicate(loginId) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public UserDTO loginUser(String loginId, String password) {
		
		UserDTO userDTO = userDAO.selectLoginUser(loginId, EncryptUtils.md5(password));
		
		return userDTO;
	}
	
	

}
