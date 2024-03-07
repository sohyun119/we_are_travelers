package com.travelers.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("UserDAO")
public interface UserDAO {
	
	public int insertUser(
			@Param("email") String email
			, @Param("name") String name
			, @Param("loginId") String loginId
			, @Param("password") String password
			);

	
	public int selectDuplicate(@Param("loginId") String loginId);
	
	
}
