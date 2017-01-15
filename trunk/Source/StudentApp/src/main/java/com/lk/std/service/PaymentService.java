package com.lk.std.service;

import java.util.List;

import com.lk.std.model.Payments;

public interface PaymentService {

	public Payments savePaymet(Payments payments);
	
	public List<Payments> findAll();
	
	public Payments updatePaymet(Payments payments);
	
	public int removePayment(long paymentId,long studentId);
	
	public List<Payments> findAllUsingStudentId(long studentId);
	
}
