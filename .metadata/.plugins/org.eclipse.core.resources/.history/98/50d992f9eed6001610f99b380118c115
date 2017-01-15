package com.lk.std.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.AttendanceRepository;
import com.lk.std.model.Attendance;

@Service
@Transactional
public class AttendanceServiceImp implements AttendanceService {

	@Autowired
	AttendanceRepository attendanceRepository;
	
	@Override
	public Attendance save(Attendance att) {
		 return attendanceRepository.save(att);
		
	}

}
