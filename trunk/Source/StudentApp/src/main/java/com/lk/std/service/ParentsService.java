package com.lk.std.service;

import java.util.List;

import com.lk.std.model.Parents;
import com.lk.std.model.Student;

public interface ParentsService {

	public List<Parents> findByStudent(Student student);

	public Parents save(Parents parents);

	public Parents findById(Long id);
}
