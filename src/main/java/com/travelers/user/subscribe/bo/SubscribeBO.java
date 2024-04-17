package com.travelers.user.subscribe.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelers.user.dto.SubscribeDTO;
import com.travelers.user.subscribe.dao.SubscribeDAO;

@Service
public class SubscribeBO {
	
	@Autowired
	private SubscribeDAO subscribeDAO;
	
	public int addSubscribeUser(int thisUserCd, int userCd, String thisUserName, String userName) {
		return subscribeDAO.insertSubscribeUser(thisUserCd, userCd, thisUserName, userName);
	}
	
	public int deleteSubscribeUser(int subscribeCd) {
		return subscribeDAO.deleteSubscribeUser(subscribeCd);
	}

	public boolean isSubscribeUser(int thisUserCd, int userCd) {
		
		int count = subscribeDAO.isSubscribeUser(thisUserCd, userCd);
		
		if(count >= 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<SubscribeDTO> subscribeUserList(int userCd){
		return subscribeDAO.subscribeUserList(userCd);
	}
	
	public List<SubscribeDTO> iSubscribeUserList(int thisUserCd){
		return subscribeDAO.iSubscribeUserList(thisUserCd);
	}
	
	
}
