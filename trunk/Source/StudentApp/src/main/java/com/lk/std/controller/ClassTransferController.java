package com.lk.std.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lk.std.constant.ApplicationConstants;
import com.lk.std.constant.OLSIMSEnumConstant;
import com.lk.std.constant.OLSIMSEnumConstant.Action;
import com.lk.std.constant.OLSIMSEnumConstant.ActiveStatus;
import com.lk.std.constant.OLSIMSEnumConstant.TransferStatus;
import com.lk.std.dto.AttendanceDto;
import com.lk.std.dto.ClassTransferDto;
import com.lk.std.model.Attendance;
import com.lk.std.model.Branch;
import com.lk.std.model.ClassSchedule;
import com.lk.std.model.Grade;
import com.lk.std.model.Student;
import com.lk.std.service.AttendanceService;
import com.lk.std.service.BranchService;
import com.lk.std.service.ClassScheduleService;
import com.lk.std.service.GradeService;
import com.lk.std.service.StudentService;


@Controller
@RequestMapping
public class ClassTransferController {
	
	@Autowired
	GradeService gradeService;

	@Autowired
	AttendanceService attendanceService;

	@Autowired
	BranchService branchService;

	@Autowired
	StudentService studentService;
	
	@Autowired
	ClassScheduleService classScheduleService;
	
	  @RequestMapping(value = "/classschedule_transfer", method = RequestMethod.GET)
	  public ModelAndView getclassschedule_transfer(HttpServletRequest request) {
	    ModelMap modelMap = new ModelMap(); 
	    List<Grade> gradesList = new ArrayList<Grade>();
	    List<Student> students = new ArrayList<Student>();
	    List<ClassSchedule> classSchedulesList = new ArrayList<ClassSchedule>();
	    List<Branch> branchList =new ArrayList<Branch>();

	    Branch selectedBranch=new Branch();
	    Grade selectedGrade=new Grade();
	    
	    long branchId=0;
	    long grade_id=0;
	    int academic_year=0;
	    int selectYear=0;
	  
	    
	    System.out.println("CLASS TRANSFER 1111111111111111");
	    try {
	    	
	    	if (!StringUtils.isBlank(request.getParameter("branchId"))) {
				branchId = Long.parseLong(request.getParameter("branchId").trim());
				
			}
			if (branchId > 0) {
				Branch b1= branchService.findById(branchId);
				if(b1!=null){
					
					selectedBranch=b1;			
					branchList.add(b1);			
					   
					   if (!StringUtils.isBlank(request.getParameter("gradeId"))) {
						   grade_id = Long.parseLong(request.getParameter("gradeId").trim());
						
						}
					   
					   if(grade_id>0) {
						   selectedGrade=gradeService.findById(grade_id);
						  // System.out.println("CLASS TRANSFER SELECT GRADE "+selectedGrade);
						   modelMap.addAttribute("selectGrade",selectedGrade);
						   
						   
						   
					   }else{
							   
							gradesList = gradeService.findByBranch(b1);
							if(gradesList!=null){
								//   System.out.println("CLASS TRANSFER 44444444444444444444");		
								}else{
										//   System.out.println("CLASS TRANSFER 55555555555555555");
									}
					
					   }
					   
					   
					   if(branchId>0 && grade_id>0) {
						   if (!StringUtils.isBlank(request.getParameter("academic_year"))) {
							   academic_year = Integer.parseInt(request.getParameter("academic_year").trim());
								//   System.out.println("CLASS TRANSFER ACADEMIX YEAR " +academic_year);
								//   
								if(academic_year>0){
									selectYear=academic_year;
									classSchedulesList=classScheduleService.getAllScheduleByGradeIdAndAcademicYear_not_transfered( grade_id, academic_year);
								//	  System.out.println("CLASS TRANSFER ACADEMIX YEAR LIST");
									  
										for (ClassSchedule branch : classSchedulesList) {
											//  System.out.println("CLASS SCHEDULEE 1111111111111 "+branch.getStatus());
										}
								}
								   
							} 
						   
					   }
					
				}else{
				//	   System.out.println("CLASS TRANSFER 66666666666666");
					branchList=branchService.findAll();
				}
			} else {
				
				selectedBranch.setId(0);
				selectedBranch.setCode("SELECT CODE");
				
				branchList=branchService.findAll();
			
			}
			
			
	    	
	    }catch (Exception e) {
	    	
	    	  
	    	   e.printStackTrace();
		}
	    
	    System.out.println("CLASS SELECT BRANCH ID CODE "+selectedBranch.getId()+" /"+selectedBranch.getCode());
	    System.out.println("CLASS SELECT GRADE ID CODE "+selectedGrade.getId()+" /"+selectedGrade.getGrade());
	    
	    modelMap.addAttribute("status", OLSIMSEnumConstant.TransferStatus.values());
	    
		modelMap.addAttribute("selectYear", selectYear);
	    modelMap.addAttribute("selectBranch",selectedBranch);
		modelMap.addAttribute("selectGrade",selectedGrade);
		modelMap.addAttribute("gradeList", gradesList);
		
		 List<Grade> gradesList_new = gradeService.findAll();
		
		modelMap.addAttribute("gradeList_trans", gradesList_new);
		
		modelMap.addAttribute("classSchedulesList", classSchedulesList);		
		
	
		modelMap.addAttribute("result", "");
		modelMap.addAttribute("branchList", branchList);

	 
	    return new ModelAndView("classschedule_transfer", modelMap);
	  }
	  
	  @RequestMapping(value = "/add_class_schedule_transfer", method = RequestMethod.GET)
		public ModelAndView addTransferSchedule(HttpServletRequest request, @ModelAttribute("classschedule") ClassTransferDto classTransferDto,
				BindingResult errors) {
		  
		  List<Grade> gradesList = new ArrayList<Grade>();
		    List<Student> students = new ArrayList<Student>();
		    List<ClassSchedule> classSchedulesList = new ArrayList<ClassSchedule>();
		    List<Branch> branchList =new ArrayList<Branch>();
		    
		    long transfer_grade_id=0;

		    Branch selectedBranch=new Branch();
		    Grade selectedGrade=new Grade();
		  
			System.out.println("=================== STUDENT343434343434344 ");
			if (errors.hasErrors()) {
				System.out.println("------------error occured");
			}
			 ModelMap modelMap = new ModelMap(); 
			Action action = null;
			
			int next_academic_year= Integer.parseInt(request.getParameter("next_academic_year").trim());
			//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			int update=0;
			int addNew=0;
			
			int checkExistsYEar=0;
			
			for (ClassSchedule att : classTransferDto.getClassSchedulesList()) {
				
				if(next_academic_year==att.getAcademicyear()){
					checkExistsYEar=1;
				}
			};
			
			
			if (!StringUtils.isBlank(request.getParameter("transfer_grade_id"))) {
				transfer_grade_id = Long.parseLong(request.getParameter("transfer_grade_id").trim());
			}
			
			Grade new_grade=gradeService.findById(transfer_grade_id);     
			
			if(checkExistsYEar==0) {
			
				for (ClassSchedule att : classTransferDto.getClassSchedulesList()) {

					
					if(att.getStatus()==TransferStatus.NOT_TRANSFER){
					
						ClassSchedule cl=classScheduleService.findById(att.getId());
						cl.setRemarks(att.getRemarks());						
						int  sss=classScheduleService.addClassSchdeule(cl);
						
						System.out.println("=================== STUDENT STATUS 2222222 NOT TRASNFERD UPODAAS "+sss);
					}else{
							
						//	update+=classScheduleService.updateScheduleStatusUsingGradeIdAndStudentId(att.getStudent().getId(), att.getGrade().getId());
						if(new_grade!=null){
							
							
							
							
							// UPDATE CURRENT CLASS STATUS AS TRANSFERED ////////////////////
							ClassSchedule cl=classScheduleService.findById(att.getId());
							cl.setRemarks("PAST CLASS");
							cl.setStatus(TransferStatus.TRANSFER);						
							int  sss=classScheduleService.addClassSchdeule(cl);
							
							
							///////////// TRANSFER TO CLASS AND STATUS AS NOT TRASFERED//////////
							if(!StringUtils.isBlank(att.getRemarks())) {
								
							}else{
								att.setRemarks("-");
							}
							
							long newId=1;
							try{
								newId=classScheduleService.getNextClassScheduleId();
							}catch (Exception e) {
								newId=1;
							}
							att.setId(newId);
							att.setVersionId(1);
							att.setGrade(new_grade);
							att.setAcademicyear(next_academic_year);
							att.setStatus(TransferStatus.NOT_TRANSFER);
							att.setRemarks("CRRENT CLASS -"+att.getRemarks());
							addNew+=classScheduleService.addClassSchdeule(att);
							
							Student stPast=studentService.findById(att.getStudent().getId());
							stPast.setGrade(new_grade);							
							Student s=studentService.save(stPast);
						
							modelMap.addAttribute("result", "added");
							
						}else{
							modelMap.addAttribute("result", "select_grade");
							
						}
					
					}
				}
			
			}else{
				modelMap.addAttribute("result", "exists_same_year");
			}
			
			System.out.println("=================== ADDDDEDDD "+addNew);
			System.out.println("=================== UPDATEDDD "+update);
		
			System.out.println("=================== DONEEEEEEEEEEEEEEEEE ");
			
			modelMap.addAttribute("branchList", branchList);
			modelMap.addAttribute("gradeList_trans", gradesList);
			return new ModelAndView("classschedule_transfer", modelMap);
			
		}

}
