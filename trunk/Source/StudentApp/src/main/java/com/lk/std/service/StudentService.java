package com.lk.std.service;

import com.lk.std.model.Student;

public interface StudentService {

	public Student save(Student student);

	public  Student findById(long stdId);
	

}
