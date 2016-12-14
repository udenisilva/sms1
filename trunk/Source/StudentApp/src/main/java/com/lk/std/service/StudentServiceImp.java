package com.lk.std.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.StudentRepository;
import com.lk.std.model.Student;

@Service
@Transactional
public class StudentServiceImp implements StudentService{

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student save(Student student) {		 
		 return studentRepository.save(student); 
	}
	
 
}
