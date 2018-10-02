package com.gosang.swp.service;

import java.util.List;

import com.gosang.swp.domain.Criteria;
import com.gosang.swp.domain.ReplyVO;


public interface ReplyService {
	void register(ReplyVO reply) throws Exception;
	
	void modify(ReplyVO reply) throws Exception;
	
	void remove(Integer rno) throws Exception;
	
	List<ReplyVO> listReplyPage(Integer bno, Criteria cri) throws Exception;
	
	int getTotalCount(Integer bno) throws Exception;
	
	//EEE
	ReplyVO ReadRno(Integer rno) throws Exception;
}
