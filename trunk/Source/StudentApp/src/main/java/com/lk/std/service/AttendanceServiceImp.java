package com.lk.std.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.AttendanceRepository;
import com.lk.std.dto.AttendanceDto;
import com.lk.std.model.Attendance;
import com.lk.std.model.Grade;

@Service
@Transactional
public class AttendanceServiceImp implements AttendanceService {

	@Autowired
	AttendanceRepository attendanceRepository;
	
	@Override
	public Attendance save(Attendance att) {
		 return attendanceRepository.save(att);
		
	}

	@Override
	public List<Attendance> findByGradeAndAttDate(Grade grade, Date bDate) { 
		return attendanceRepository.findByGradeAndAttDate(grade,bDate);
	}

	@Override
	public void delete(Attendance att) {
		attendanceRepository.delete(att);
		
	}

}
