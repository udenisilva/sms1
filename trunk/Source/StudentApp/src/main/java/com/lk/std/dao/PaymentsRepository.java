package com.lk.std.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.Payments;
import com.lk.std.model.Student;

public interface PaymentsRepository extends CrudRepository<Payments,Long>{

	public List<Payments> findByStudent(Student student);

	public Payments findById(Long id);

}
