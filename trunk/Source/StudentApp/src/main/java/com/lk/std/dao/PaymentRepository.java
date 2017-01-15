package com.lk.std.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.lk.std.model.Payments;

public interface PaymentRepository extends JpaRepository<Payments, Long> {

	
	@Modifying
	@Transactional
	@Query("delete from payments p where p.student.id=?1 and p.id=?2")
	int deletePaymentDetails(long studentId,long paymentId);
	
	@Query("select p from payments p where p.student.id=?1")
	List<Payments> findAllUsingStudentId(long studentId);
	
}
