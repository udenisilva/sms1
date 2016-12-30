package com.lk.std.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.Parents;
import com.lk.std.model.Student;
 

public interface ParentsRepository extends CrudRepository<Parents,Long>{
	
	public Parents findById(Long id);
	
	public Parents findByStudent(Student student);
	
	public List<Student> findStudentById(Long id);

}
