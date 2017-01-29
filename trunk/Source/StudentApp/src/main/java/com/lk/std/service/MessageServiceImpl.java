package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.MessageRepository;
import com.lk.std.model.Messages;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

	
	@Autowired
	MessageRepository messagerepository;
	
	@Override
	public List<Messages> findAll() {
		return (List<Messages>) messagerepository.findAll();
	}

	@Override
	public Messages saveMessage(Messages messages) {
		return messagerepository.save(messages);
	}

	

	@Override
	public int deleteMessageByMessageIdAndGradeId(long msgId,long gradeId) {
		return messagerepository.deleteMessageByMessageIdAndGradeId(msgId,gradeId);
	}

	@Override
	public List<Messages> findAllMessageInGrade(long gradeId) {
		return messagerepository.findAllMessageInGrade ( gradeId);
	}

	
	
	

}
