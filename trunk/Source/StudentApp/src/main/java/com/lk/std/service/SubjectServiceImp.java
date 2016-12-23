package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.SubjectRepository;
import com.lk.std.model.Subject;

@Service
@Transactional
public class SubjectServiceImp implements SubjectService {

	@Autowired
	SubjectRepository subjectRepository;
	
	@Override
	public List<Subject> findAll() {		 
		return (List<Subject>) subjectRepository.findAll();
	}

	@Override
	public List<Subject> findByGrade(Long gradeId) {
		return subjectRepository.findByGrade(gradeId);
	}

}
