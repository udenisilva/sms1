package com.lk.std.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.ClassSchedule;


public interface ClassScheduleRepository extends CrudRepository<ClassSchedule, Long> {
	
	@Query("select max(id)+1 from class_schedule ")
	public long getNextClassScheduleId();
	
	@Query("select c from class_schedule c where c.grade.id=?1 and c.student.id=?2")
	public ClassSchedule getSelectedGradeAndStudentClassDetails(long gradeId,long studentId);
	
	@Modifying
	@Query("update class_schedule c set c.status=?2 where c.student.id=?1")
	public int updateScheduleStatus(long studentId,Enum s);
	
	@Query("select c from class_schedule c where  c.student.id=?1 and c.status=?2")
	public List<ClassSchedule>  getActiveClassScheduleByStudent(long studentId,Enum s);
	
	
	@Query("select c from class_schedule c where  c.student.id=?1 and c.grade.id=?2")
	public List<ClassSchedule> getAllScheduleByStudent(long studentId,long gradeId);
	
	@Query("select c from class_schedule c where   c.grade.id=?1 and c.academicyear=?2 and c.status=0")
	public List<ClassSchedule> getAllScheduleByGradeIdAndAcademicYear_not_transfered(long gradeId,int academicyear);
	
	@Modifying
	@Query("update class_schedule c set c.status=2 where c.student.id=?1 and c.grade.id=?2")
	public int updateScheduleStatusUsingGradeIdAndStudentId(long studentId,long gradeId);

}
