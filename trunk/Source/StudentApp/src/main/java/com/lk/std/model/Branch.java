package com.lk.std.model;

import java.io.Serializable;
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

@Entity(name = "branch")
@Table(name = "branch")
public class Branch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "branch_id", nullable = false)
	private long id;

	@Column(name = "branch_code", nullable = false)
	private String code;

	@Column(name = "branch_address", nullable = false)
	private String address;

	@Column(name = "branch_tel", nullable = false)
	private int tel;

	@Column(name = "branch_fax", nullable = false)
	private int fax;

	@Column(name = "branch_email", nullable = false)
	private String email;
		
	@OneToOne(mappedBy="branch",optional=true)
	private Student student;
	
	@OneToOne(mappedBy="branch",optional=true)
	private Subject subject;

	@OneToMany(mappedBy="branch") 
	private List<Grade> grade;
	
	@OneToMany(mappedBy="grade")
	private List<Staff> staff;
	
	@Version
	@Column(name = "version_id")
	private int versionId;
	
	public Branch() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getFax() {
		return fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Grade> getGrade() {
		return grade;
	}

	public void setGrade(List<Grade> grade) {
		this.grade = grade;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

 

}
