package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.ParentsRepository;
import com.lk.std.model.Parents;
import com.lk.std.model.Student;

@Service
@Transactional
public class ParentsServiceImp implements ParentsService {

	@Autowired
	ParentsRepository parentsRepository;
	 
	
	@Override
	public List<Parents> findByStudent(Student student) { 
		return parentsRepository.findByStudent(student);
	}

	@Override
	public Parents save(Parents parents) {		 
		return parentsRepository.save(parents);
	}
 
	@Override
	public Parents findById(Long id) {		 
		return parentsRepository.findById(id);
	}

}
