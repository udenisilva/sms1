package com.lk.std.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.lk.std.constant.OLSIMSEnumConstant.ActiveStatus;
import com.lk.std.constant.OLSIMSEnumConstant.Gender;
 

@Entity(name = "student")
@Table(name = "student")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id", nullable = false)
	private long id;
	
	@Column(name = "student_code", nullable = false)
	private String code;
	
	@Column(name = "student_name", nullable = false)
	private String name;
	
	@Column(name = "student_gender", nullable = false)
	private Gender gender;
	
	@Column(name = "student_joinDate", nullable = false)
	private Date joinDate;
	
	@Column(name = "student_leftDate", nullable = true)
	private Date leftDate;
	
	@Column(name = "student_status", nullable = false)
	private ActiveStatus status;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="branch",nullable = false)
	private Branch branch;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "parent_id", nullable = true)
	private Parents parents;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "guardians_id", nullable = true)
	private Guardians guardians;
	
	@OneToMany(mappedBy="student") 
	private List<Marks> marks;
	
	@OneToMany(mappedBy="student") 
	private List<ClassSchedule> classSchedules;
	
	@OneToMany(mappedBy="student") 
	private List<Payments> payments;
	
	@OneToMany(mappedBy="student") 
	private List<Attendance> attendances;
	
	@Version
	@Column(name = "version_id")
	private int versionId;

	public Student() {
		super();		 
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getLeftDate() {
		return leftDate;
	}

	public void setLeftDate(Date leftDate) {
		this.leftDate = leftDate;
	}

	public ActiveStatus getStatus() {
		return status;
	}

	public void setStatus(ActiveStatus status) {
		this.status = status;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Parents getParents() {
		return parents;
	}

	public void setParents(Parents parents) {
		this.parents = parents;
	}

	public Guardians getGuardians() {
		return guardians;
	}

	public void setGuardians(Guardians guardians) {
		this.guardians = guardians;
	}

	public List<Marks> getMarks() {
		return marks;
	}

	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}

	public List<ClassSchedule> getClassSchedules() {
		return classSchedules;
	}

	public void setClassSchedules(List<ClassSchedule> classSchedules) {
		this.classSchedules = classSchedules;
	}

	public List<Payments> getPayments() {
		return payments;
	}

	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", code=" + code + ", name=" + name + ", gender=" + gender + ", joinDate="
				+ joinDate + ", leftDate=" + leftDate + ", status=" + status + ", branch=" + branch + ", parents="
				+ parents + ", guardians=" + guardians + ", marks=" + marks + ", classSchedules=" + classSchedules
				+ ", payments=" + payments + ", attendances=" + attendances + ", versionId=" + versionId + "]";
	}

 
	
	
}
