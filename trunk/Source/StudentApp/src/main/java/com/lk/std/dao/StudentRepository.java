package com.lk.std.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.Grade;
import com.lk.std.model.Student;

@Transactional
public interface StudentRepository extends CrudRepository<Student,Long> {


	
	
	public Student findById(long stdId);

	public List<Student> findByGrade(Grade grade);
	
	@Query("SELECT code FROM student order by id ASC")
	public List<String> getLastStudentDetails();
	
	@Query("select max(id)+1 from student ")
	public int getNextStudent_id();

}
