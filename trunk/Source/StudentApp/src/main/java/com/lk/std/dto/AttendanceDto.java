package com.lk.std.dto;

import java.util.Date;
import java.util.List;

import com.lk.std.model.Attendance;
import com.lk.std.model.Grade;

public class AttendanceDto {

	public Date date;
	
	private Grade grade;
	
	public List<Attendance> attendance;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}
	
	
}
