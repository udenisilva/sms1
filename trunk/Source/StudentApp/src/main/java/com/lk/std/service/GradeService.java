package com.lk.std.service;

import java.util.List;

import com.lk.std.model.Branch;
import com.lk.std.model.Grade;
import com.lk.std.model.Student;

public interface GradeService {

	public List<Grade> findAll();
	
	public Grade save(Grade grade);
	
	public int remove(Grade grade);

	public Grade findById(long gradeId);
	
	public List<Student> findStudentById(long gradeID);

	public List<Grade> findByBranch(Branch branch);
	
	public int findByGradeAndId(String grade,long gradeId);
}
