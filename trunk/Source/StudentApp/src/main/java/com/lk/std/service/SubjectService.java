package com.lk.std.service;

import java.util.List;

import com.lk.std.model.Branch;
import com.lk.std.model.Grade;
import com.lk.std.model.Subject;

public interface SubjectService {

	public List<Subject> findAll();

	public List<Subject> findByGrade(Grade grade); 
	
	public Subject saveSubjectDetails(Subject subject);
	public List<Subject> getSubjectDetails(int code);
	public Subject findById(long id);
	public List<Subject> findAllSubjectsByBranchId(long branchId);
	
	public String generateNextSubjectCode();
	
	public List<Subject> findByBranchIdAndGradeId(long branchId,long gradeId);
}
