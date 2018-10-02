package com.gosang.swp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gosang.swp.domain.MessageVO;
import com.gosang.swp.persistence.MessageDAO;
import com.gosang.swp.persistence.PointDAO;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Inject
	private MessageDAO messageDAO;
	
	@Inject
	private PointDAO pointDAO;
	
	private static final int WRITE_POINT = 10;
	private static final int READ_POINT = 5;
	
	
	@Transactional
	@Override
	public void addMessage(MessageVO message) throws Exception {
		messageDAO.create(message);
		pointDAO.updatePoint(message.getSender(), WRITE_POINT);
	}

	@Transactional
	@Override
	public MessageVO readMessage(String uid, Integer mid) throws Exception {
		messageDAO.updateState(mid);
		pointDAO.updatePoint(uid, READ_POINT);
		
		return messageDAO.readMessage(mid);
	}
	

}