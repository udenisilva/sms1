package com.lk.std.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.constant.OLSIMSEnumConstant.TransferStatus;
import com.lk.std.dao.ClassScheduleRepository;
import com.lk.std.model.ClassSchedule;

@Service
@Transactional
public class ClassScheduleServiceImpl implements ClassScheduleService {
	
	@Autowired
    ClassScheduleRepository classschedulerepository;

	@Override
	public int addClassSchdeule(ClassSchedule classSchedule) {
		int added=0;
		ClassSchedule cl=classschedulerepository.save(classSchedule);
		
		if(cl!=null){			
			added=1;
		}else{
			added=0;
		}
		return added;
	}

	@Override
	public ClassSchedule getSelectedGradeAndStudentClassDetails(long gradeId, long studentId) {
		return classschedulerepository.getSelectedGradeAndStudentClassDetails(gradeId, studentId);
	}

	@Override
	public int updateScheduleStatus(long studentId,Enum s) {
		return classschedulerepository.updateScheduleStatus(studentId,s);
	}

	@Override
	public ClassSchedule getActiveClassScheduleByStudent(long studentId) {
		ClassSchedule classSchedule=new ClassSchedule();
		List<ClassSchedule>  cl=new ArrayList<ClassSchedule> ();		
		try{
		System.out.println(" CLZ================================= 111111111111111");
			cl=classschedulerepository.getActiveClassScheduleByStudent(studentId,TransferStatus.NOT_TRANSFER);
			int exists=0;
			for (ClassSchedule classSchedule3 : cl) {
				exists=1;
				classSchedule=classSchedule3;
			} 			
			if(exists==1){
				System.out.println(" CLZ================================= 2222222222222");
			}else{
				classSchedule=new ClassSchedule();
				System.out.println(" CLZ================================= 3333333333333333");
			}
		
		}catch (Exception e) {
			System.out.println(" CLZ================================= 4444444444444444444");
			classSchedule=new ClassSchedule();
		}
		return classSchedule;
	}

	@Override
	public List<ClassSchedule> getAllScheduleByStudent(long studentId, long gradeId) {		
		return classschedulerepository.getAllScheduleByStudent(studentId,gradeId);
	}

	@Override
	public List<ClassSchedule> getAllScheduleByGradeIdAndAcademicYear_not_transfered(long gradeId,int academicyear) {
		return classschedulerepository.getAllScheduleByGradeIdAndAcademicYear_not_transfered( gradeId, academicyear);
	}

	@Override
	public int updateScheduleStatusUsingGradeIdAndStudentId(long studentId, long gradeId) {
		return classschedulerepository.updateScheduleStatusUsingGradeIdAndStudentId(studentId,gradeId);
	}

	@Override
	public ClassSchedule findById(long id) {
		return classschedulerepository.findOne(id);
	}

	@Override
	public long getNextClassScheduleId() {
		
		long id=0;		
		try{			
			id=classschedulerepository.getNextClassScheduleId();
		}catch (Exception e) {
			id=1;
		}		
		return id;

	}
	
	

}
