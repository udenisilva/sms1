package com.lk.std.service;

import java.util.List;

import com.lk.std.model.Grade;
import com.lk.std.model.Student;

public interface StudentService {

	public Student save(Student student);

	public  Student findById(long stdId);

	public List<Student> findByGrade(Grade grade);
	
	public String getLastStudentDetails();
	
	public int getNextStudent_id();
	
	public List<Student> findAll();
	

}
