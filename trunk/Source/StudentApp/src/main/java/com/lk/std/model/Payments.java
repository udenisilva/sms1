package com.lk.std.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.lk.std.constant.OLSIMSEnumConstant.PaymentType;

@Entity(name = "payments")
@Table(name = "payments")
public class Payments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payments_id", nullable = false)
	private long id;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "student_id", nullable = true)
	private Student student;
	
	@Column(name = "payment_type", nullable = false)
	private String paymentType;
	
	@Column(name = "payments_amount", nullable = false)
	private double amount;
	
	@Column(name = "payments_date", nullable = false)
	private Date paymentDate;
	
	@Column(name = "payments_academic_year", nullable = false)
	private int academicyear;

	@Version
	@Column(name = "version_id")
	private int versionId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getAcademicyear() {
		return academicyear;
	}

	public void setAcademicyear(int academicyear) {
		this.academicyear = academicyear;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	
	
	
}
