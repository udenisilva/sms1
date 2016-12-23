package com.lk.std.service;

import java.util.List;
 
import com.lk.std.model.Payments;
import com.lk.std.model.Student;

public interface PaymentsService {

	public Payments findById(Long id);
	
	public List<Payments> findByStudent(Student student);
 
	public Payments save(Payments payments);
}
