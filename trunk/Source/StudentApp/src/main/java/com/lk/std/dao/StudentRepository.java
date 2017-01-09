package com.lk.std.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.Grade;
import com.lk.std.model.Student;

public interface StudentRepository extends CrudRepository<Student,Long> {

	public Student findById(long stdId);

	public List<Student> findByGrade(Grade grade);

}
