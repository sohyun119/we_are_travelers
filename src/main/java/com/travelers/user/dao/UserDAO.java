package com.travelers.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.travelers.user.dto.UserDTO;

@Repository("UserDAO")
public interface UserDAO {
	
	public int insertUser(
			@Param("email") String email
			, @Param("name") String name
			, @Param("loginId") String loginId
			, @Param("password") String password
			);

	
	public int selectDuplicate(@Param("loginId") String loginId);
	
	public UserDTO selectLoginUser(
			@Param("loginId") String loginId
			, @Param("password") String password);
	
	
	
	
}
