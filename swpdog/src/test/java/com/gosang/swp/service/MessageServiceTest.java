package com.gosang.swp.service;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosang.swp.domain.MessageVO;
import com.gosang.swp.service.MessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class MessageServiceTest {

	@Inject
	private MessageService service;

	private static Logger logger = LoggerFactory.getLogger(MessageServiceTest.class);

	@Test
	public void testWriteMessage() throws Exception {
		MessageVO msg = new MessageVO();
		msg.setSender("user1");
		msg.setTargetid("user2");
		msg.setMessage("Message 내용");
		logger.info("MESSAGE>>" + msg);
		service.addMessage(msg);
	}
}
