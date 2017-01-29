package com.lk.std.service;

import java.util.List;

import com.lk.std.model.ClassSchedule;

public interface ClassScheduleService {
	
	public long getNextClassScheduleId();

	public int addClassSchdeule(ClassSchedule classSchedule);
	
	public ClassSchedule findById(long id);
	
	public ClassSchedule getSelectedGradeAndStudentClassDetails(long gradeId,long studentId);
	
	public int updateScheduleStatus(long studentId,Enum sa );
	
	public ClassSchedule getActiveClassScheduleByStudent(long studentId);
	
	public List<ClassSchedule> getAllScheduleByStudent(long studentId,long gradeId);
	
	public List<ClassSchedule> getAllScheduleByGradeIdAndAcademicYear_not_transfered(long gradeId,int academicyear);
	
	public int updateScheduleStatusUsingGradeIdAndStudentId(long studentId,long gradeId);
}
