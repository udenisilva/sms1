package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.PaymentsRepository;
import com.lk.std.model.Payments;
import com.lk.std.model.Student;

@Service
@Transactional
public class PaymentsServiceImp implements PaymentsService {

	@Autowired
	PaymentsRepository paymentsRepository;
	
	@Override
	public Payments findById(Long id) {		 
		return paymentsRepository.findById(id);
	}

	@Override
	public List<Payments> findByStudent(Student student) { 
		return paymentsRepository.findByStudent(student);
	}

	@Override
	public Payments save(Payments payments) { 
		return paymentsRepository.save(payments);
	}

}
