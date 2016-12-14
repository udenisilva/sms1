package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.GradeRepository;
import com.lk.std.model.Grade;

@Service
@Transactional
public class GradeServiceImp implements GradeService{

	@Autowired
	GradeRepository gradeRepository;
	
	@Override
	public List<Grade> findAll() {		
		return (List<Grade>) gradeRepository.findAll();
	}

}
