package com.lk.std.service;

import java.util.List;

import com.lk.std.model.Subject;

public interface SubjectService {

	public List<Subject> findAll();

	public List<Subject> findByGrade(Long gradeId); 
}
