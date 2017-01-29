package com.lk.std.service;

import java.util.List;

import com.lk.std.model.Grade;
import com.lk.std.model.Messages;

public interface MessageService {

	
	public List<Messages> findAll();
	
	public Messages saveMessage(Messages message);
	
	public int deleteMessageByMessageIdAndGradeId(long msgId,long gradeId);
	
	List<Messages> findAllMessageInGrade (long gradeId);
	
}
