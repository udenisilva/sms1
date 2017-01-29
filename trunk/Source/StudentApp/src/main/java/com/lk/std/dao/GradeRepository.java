package com.lk.std.dao;
 

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.Branch;
import com.lk.std.model.Grade;
import com.lk.std.model.Student;

public interface GradeRepository extends CrudRepository<Grade, Long> {

	public Grade findById(long gradeId);

	public List<Student> findStudentById(long gradeID);

	public List<Grade> findByBranch(Branch branch);
	
	public Grade findByGradeAndId(String grade,long gradeId);

}
