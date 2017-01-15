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

import com.lk.std.constant.OLSIMSEnumConstant.ActiveStatus;
import com.lk.std.constant.OLSIMSEnumConstant.AttendanceStatus;

@Entity(name = "attendance")
@Table(name = "attendance")
public class Attendance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "attendance_id", nullable = false)
	private long id;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "grade_id", nullable = true)
	private Grade grade;
	
	@Column(name = "attendance_date", nullable = false)
	private Date attDate;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "student_id", nullable = true)
	private Student student;
	
	@Column(name = "attendance_status", nullable = false)
	private AttendanceStatus status;
	
	@Version
	@Column(name = "version_id")
	private int versionId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Date getAttDate() {
		return attDate;
	}

	public void setAttDate(Date attDate) {
		this.attDate = attDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public AttendanceStatus getStatus() {
		return status;
	}

	public void setStatus(AttendanceStatus status) {
		this.status = status;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

}
