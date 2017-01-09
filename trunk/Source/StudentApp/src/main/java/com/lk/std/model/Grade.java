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

@Entity(name = "grade")
@Table(name = "grade")
public class Grade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grade_id", nullable = false)
	private long id;

	@Column(name = "grade", nullable = false)
	private String grade;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "branch_id", nullable = true)
	private Branch branch;

	@OneToOne(mappedBy = "grade", optional = true)
	private Admission admission;
	
	@OneToMany(mappedBy="grade") 
	private List<Marks> marks;
	
	@OneToMany(mappedBy="grade") 
	private List<ClassSchedule> classSchedules;
	
	@OneToMany(mappedBy="grade") 
	private List<Messages> messages;
	
	@OneToMany(mappedBy="grade") 
	private List<Attendance> attendances;
	
	@OneToMany(mappedBy="grade")
	private List<Staff> staff; 
	
	@OneToMany(mappedBy="grade")
	private List<Student> student; 
	
	@Version
	@Column(name = "version_id")
	private int versionId;

	public Grade() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
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

	public List<Messages> getMessages() {
		return messages;
	}

	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	 

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

 
	

}
