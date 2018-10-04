package com.dogfriend.persistence;

import com.dogfriend.domain.MessageVO;

public interface MessageDAO {
	
	void create(MessageVO message) throws Exception;
	MessageVO readMessage(Integer mid) throws Exception;
	void updateState(Integer mid) throws Exception;
	
}
