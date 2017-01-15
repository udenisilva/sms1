package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.lk.std.dao.PaymentRepository;
import com.lk.std.model.Payments;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentRepository paymentrepo;

	@Override
	public Payments savePaymet(Payments payments) {
		return paymentrepo.save(payments);
	}

	@Override
	public List<Payments> findAll() {
		return paymentrepo.findAll();
	}

	@Override
	public Payments updatePaymet(Payments payments) {
		return paymentrepo.saveAndFlush(payments);
	}

	@Override
	public int removePayment(long paymentId, long studentId) {
		return paymentrepo.deletePaymentDetails(studentId, paymentId);
	}

	@Override
	public List<Payments> findAllUsingStudentId(long studentId) {
		return paymentrepo.findAllUsingStudentId(studentId);
	}
	
	

}
