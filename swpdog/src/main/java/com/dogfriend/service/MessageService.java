package com.dogfriend.service;

import com.dogfriend.domain.MessageVO;

public interface MessageService {
	
	public void addMessage(MessageVO message) throws Exception;
	
	public MessageVO readMessage(String uid, Integer mid) throws Exception;
}
