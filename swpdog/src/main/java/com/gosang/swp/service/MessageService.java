package com.gosang.swp.service;

import com.gosang.swp.domain.MessageVO;

public interface MessageService {
	
	public void addMessage(MessageVO message) throws Exception;
	
	public MessageVO readMessage(String uid, Integer mid) throws Exception;
}
