package com.dogfriend.persistence;

import java.util.List;

import com.dogfriend.domain.Criteria;
import com.dogfriend.domain.ReplyVO;

public interface ReplyDAO {
	
	void create(ReplyVO reply) throws Exception;
	
	void update(ReplyVO reply) throws Exception;
	
	void delete(Integer rno) throws Exception;
	
	List<ReplyVO> listPage(Integer bno, Criteria cri) throws Exception;

	int getToalCount(Integer bno);

	//EEE
	ReplyVO readRno(Integer rno);
	
	int getBno(Integer rno) throws Exception;
}
