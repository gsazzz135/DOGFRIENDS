package com.gosang.swp.persistence;

import com.gosang.swp.domain.MessageVO;

public interface MessageDAO {
	
	void create(MessageVO message) throws Exception;
	MessageVO readMessage(Integer mid) throws Exception;
	void updateState(Integer mid) throws Exception;
	
}
