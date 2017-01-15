package com.lk.std.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lk.std.dto.AttendanceDto;
import com.lk.std.model.Attendance;
import com.lk.std.model.Grade;

public interface AttendanceRepository extends CrudRepository<Attendance,Long> {

	public List<Attendance> findByGradeAndAttDate(Grade grade, Date bDate);

}
