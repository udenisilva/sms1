package com.lk.std.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lk.std.model.Grade;
import com.lk.std.model.Marks;
import com.lk.std.model.Student;
import com.lk.std.model.Subject;

public class MarksDto {
	 
	private int academicyear; 
	
	private List<Marks> marks;
	 
	private Subject subject;
	 
	private Grade grade;
	
	private String examinationType;

	public int getAcademicyear() {
		return academicyear;
	}

	public void setAcademicyear(int academicyear) {
		this.academicyear = academicyear;
	}

	
	public List<Marks> getMarks() {
		return marks;
	}

	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	

	public String getExaminationType() {
		return examinationType;
	}

	public void setExaminationType(String examinationType) {
		this.examinationType = examinationType;
	}

	@Override
	public String toString() {
		return "MarksDto [academicyear=" + academicyear + ", marks=" + marks + ", subject=" + subject + ", grade="
				+ grade + "]";
	}


//	private ExaminationType examinationType;
	
	

}
