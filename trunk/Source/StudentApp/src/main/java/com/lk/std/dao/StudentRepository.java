package com.lk.std.dao;

import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.Student;

public interface StudentRepository extends CrudRepository<Student,Long> {

}
