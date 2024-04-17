package com.travelers.user.subscribe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.travelers.user.dto.SubscribeDTO;

@Repository
public interface SubscribeDAO {
	
	public int insertSubscribeUser(@Param("thisUserCd") int thisUserCd
			 , @Param("userCd") int userCd
			 , @Param("thisUserName") String thisUserName
			 , @Param("userName") String userName);

	public int deleteSubscribeUser(@Param("subscribeCd") int subscribeCd);
	
	public int isSubscribeUser(@Param("thisUserCd") int thisUserCd
							 , @Param("userCd") int userCd);
	
	public List<SubscribeDTO> subscribeUserList(@Param("userCd") int userCd);
	
	public List<SubscribeDTO> iSubscribeUserList(@Param("thisUserCd") int thisUserCd);
	
	
}
