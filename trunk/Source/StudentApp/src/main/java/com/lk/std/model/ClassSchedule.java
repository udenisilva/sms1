package com.lk.std.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.lk.std.constant.OLSIMSEnumConstant.ActiveStatus;
import com.lk.std.constant.OLSIMSEnumConstant.TransferStatus;

@Entity(name = "class_schedule")
@Table(name = "class_schedule")
public class ClassSchedule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private long id;
	
	@ManyToOne()
	@JoinColumn(name="student_id",nullable = false)
	private Student student;
	
	@ManyToOne()
	@JoinColumn(name="grade_id",nullable = false)
	private Grade grade;
	
	@Column(name = "academicyear", nullable = false)
	private int academicyear;
	
	@Column(name = "remarks", nullable = false)
	private String remarks;
	
	@Column(name = "status", nullable = false)
	private TransferStatus status;
	
	@Version
	@Column(name = "version_id")
	private int versionId;

	public long getId() {
		return id;
	}	
	

	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public int getAcademicyear() {
		return academicyear;
	}

	public void setAcademicyear(int academicyear) {
		this.academicyear = academicyear;
	}

	public TransferStatus getStatus() {
		return status;
	}

	public void setStatus(TransferStatus status) {
		this.status = status;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	
	
	
	

}
