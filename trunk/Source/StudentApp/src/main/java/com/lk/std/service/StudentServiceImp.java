package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.StudentRepository;
import com.lk.std.model.Grade;
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

	@Override
	public Student findById(long stdId) { 
		return studentRepository.findById(stdId);
	}

	@Override
	public List<Student> findByGrade(Grade grade) { 
		return studentRepository.findByGrade(grade);
	}
	
 
}
