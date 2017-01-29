package com.lk.std.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lk.std.constant.ApplicationConstants;
import com.lk.std.constant.OLSIMSEnumConstant;
import com.lk.std.constant.OLSIMSEnumConstant.Action;
import com.lk.std.constant.OLSIMSEnumConstant.ActiveStatus;
import com.lk.std.constant.OLSIMSEnumConstant.TransferStatus;
import com.lk.std.model.ClassSchedule;
import com.lk.std.model.Grade;
import com.lk.std.model.Staff;
import com.lk.std.model.Student;
import com.lk.std.service.ActionLoggerService;
import com.lk.std.service.BranchService;
import com.lk.std.service.ClassScheduleService;
import com.lk.std.service.GradeService;
import com.lk.std.service.StudentService;
import com.lk.std.util.Session;

@Controller
@RequestMapping
public class StudentProfileController {

	@Autowired
	BranchService branchService;

	@Autowired
	GradeService gradeService;

	@Autowired
	StudentService studentService;
	
	@Autowired
	ClassScheduleService classschduleservice;

	@Autowired
	private ActionLoggerService actionloggerService;
	
	
	@RequestMapping(value="view_grade_to_student",method=RequestMethod.GET)
	public ModelAndView view_grade_to_student(HttpServletRequest request){
		ModelMap modelMap = new ModelMap();
		 Grade grade=new Grade();
		 ClassSchedule classSchedule=new ClassSchedule();
		 
		long studentID=Long.parseLong(request.getParameter("id"));
		
		Student student=studentService.findById(studentID);
			
		System.out.println("11111111111111111111");
		try{
		 classSchedule=classschduleservice.getActiveClassScheduleByStudent(studentID);
		 if(classSchedule!=null){
			 System.out.println("222222222222222222222222 GRADE ID "+classSchedule.getGrade().getId());
			  grade=gradeService.findById(classSchedule.getGrade().getId());
				modelMap.addAttribute("grade", grade);
				modelMap.addAttribute("exists_grade","yes");
		 }else{
			 System.out.println("3333333333333333");
				modelMap.addAttribute("exists_grade","no");
				classSchedule.setAcademicyear(0);
		 }
	
		}catch (Exception e) {
			System.out.println("444444444444444444 ");
		//	e.printStackTrace();
			modelMap.addAttribute("exists_grade","no");
			//classSchedule=new ClassSchedule();
			// System.out.println(" CLZ STUDENT ================================= ERRRRRRRRRRRRRRRRRRR ");
			// modelMap.addAttribute("exists", "no");
			classSchedule.setAcademicyear(0);
		}
		modelMap.addAttribute("gradeList", gradeService.findAll());
		modelMap.addAttribute("student", student);	
		
		
		
		
		
		modelMap.addAttribute("grade", grade);	
		modelMap.addAttribute("current_academic_year", classSchedule.getAcademicyear());	
		
		
		return new ModelAndView("student_to_grade", modelMap);
	}
	
	
	@RequestMapping(value="update_grade_to_student",method=RequestMethod.GET)
	public String update_grade_to_student(HttpServletRequest request){
		System.out.println("ttttttttttttttttttttttttttttttttt");
		ModelMap modelMap = new ModelMap();
		System.out.println("ttttttttttttttttttttttttttttttttt GFRDAE "+request.getParameter("gradeId"));
		System.out.println("ttttttttttttttttttttttttttttttttt ACADEMIC YEAR "+request.getParameter("academic_year"));
		
		long studentID=Long.parseLong(request.getParameter("id"));
	//	long versionId=Long.parseLong(request.getParameter("versionId"));
		
		long gradeId=Long.parseLong(request.getParameter("gradeId"));

		
		if(gradeId!=0){
			
			Grade grade=gradeService.findById(gradeId);			
			
			Student student=studentService.findById(studentID);
			student.setGrade(grade);
			ClassSchedule c=new ClassSchedule();
			//try{
			
//			 c=classschduleservice.getSelectedGradeAndStudentClassDetails(gradeId, studentID);
//			if(c!=null){
//				System.out.println("==============================CLASS SCHEDULE EXISTS ");
//				c.setAcademicyear(Integer.parseInt(request.getParameter("academic_year")));
//				c.setStatus(ActiveStatus.ACTIVE);
//				c.setStudent(student);
//				c.setGrade(gradeService.findById(gradeId));
//				c.setVersionId(c.getVersionId()+1);
//			}else{
//				System.out.println("==============================CLASS SCHEDULE NOT EXISTS ");
//				c.setAcademicyear(Integer.parseInt(request.getParameter("academic_year")));
//				c.setStatus(ActiveStatus.ACTIVE);
//				c.setStudent(student);
//				c.setGrade(gradeService.findById(gradeId));
//				c.setVersionId(1);
//			}
//			}catch (Exception e) {
//				System.out.println("=======================EEEEEEEE=======CLASS SCHEDULE NOT EXISTS ");
//				c.setAcademicyear(Integer.parseInt(request.getParameter("academic_year")));
//				c.setStatus(ActiveStatus.ACTIVE);
//				c.setStudent(student);
//				c.setGrade(gradeService.findById(gradeId));
//				c.setVersionId(1);
//			}
		
			c.setAcademicyear(Integer.parseInt(request.getParameter("academic_year")));
			c.setStatus(TransferStatus.NOT_TRANSFER);
			c.setStudent(student);
			c.setGrade(gradeService.findById(gradeId));
			c.setVersionId(1);
			c.setRemarks("-");
			
			Student updateGrade=studentService.save(student);
		
		
					if (updateGrade != null) {
						// set action logger
					int update=classschduleservice.updateScheduleStatus(studentID,TransferStatus.TRANSFER);
						int add=classschduleservice.addClassSchdeule(c);
								
						return "redirect:studentprofile.htm?stdId=" +studentID+ "&" + ApplicationConstants.MESSAGE + "="
								+ ApplicationConstants.SUCCESS;
					} else {
						return "redirect:studentprofile.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
					}

		}else{
					
				return "redirect:studentprofile.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
		}
	}
	
	@RequestMapping(value="update_student_details",method=RequestMethod.GET)
	public ModelAndView show_update_student_form(HttpServletRequest request){
		ModelMap modelMap = new ModelMap();
		long id=Long.parseLong(request.getParameter("id"));
		String code=request.getParameter("code");
		
		Student student=studentService.findById(id);
		
		
		modelMap.addAttribute("genders", OLSIMSEnumConstant.Gender.values());
		modelMap.addAttribute("grade", gradeService.findAll());
		modelMap.addAttribute("student", student);
		modelMap.addAttribute("studentList", studentService.findAll());
		modelMap.addAttribute("status", OLSIMSEnumConstant.ActiveStatus.values());
		modelMap.addAttribute("msg", "UPDATE DETAILS");
		
		return new ModelAndView("studentprofile", modelMap);
	}
	
	
	

	

	@RequestMapping(value = "/studentprofile", method = RequestMethod.GET)
	public ModelAndView getHomePage(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		long stdId = 0;
		Student student = null;
		try {
			if (!StringUtils.isBlank(request.getParameter("stdId"))) {
				stdId = Long.parseLong(request.getParameter("stdId").trim());
			}
			if (stdId > 0) {
				student = studentService.findById(stdId);
			} else {
				student = new Student();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String nextCode=studentService.getLastStudentDetails();
		student.setCode(nextCode);
	//	student.setId(studentService.getNextStudent_id());

		modelMap.addAttribute("branchs", branchService.findAll());
		for (int i = 1; i < branchService.findAll().size(); i++) {
			System.out.println(branchService.findAll().get(i).getCode());
		}
		modelMap.addAttribute("genders", OLSIMSEnumConstant.Gender.values());
		modelMap.addAttribute("grade", gradeService.findAll());
		modelMap.addAttribute("student", student);
		modelMap.addAttribute("studentList", studentService.findAll());
		modelMap.addAttribute("status", OLSIMSEnumConstant.ActiveStatus.values());
		modelMap.addAttribute("msg", "NEW DETAILS");

		return new ModelAndView("studentprofile", modelMap);
	}

	@RequestMapping(value = "/createStudent", method = RequestMethod.POST)
	public String StaffPager(HttpServletRequest request, @ModelAttribute("student") Student std, BindingResult errors) {
		if (!errors.hasErrors()) {
			System.out.println("------------error occured");
		
		}else{
			System.out.println("errrrrrrrrrrrr "+errors);
			//return "redirect:studentprofile.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
			
		}
		Action action = null;
		System.out.println("" + std.getCode());
		try {
			if (!StringUtils.isBlank(request.getParameter("id"))) {
				action = Action.USER_UPDATED;
			} else {
				action = Action.USER_CREATED;
			}

		} catch (Exception e) {
			System.out.println("------------ Exception occured");
		}

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		if (!StringUtils.isBlank(request.getParameter("joinDate"))) {
			try {
				Date startDate;
				startDate = df.parse(request.getParameter("joinDate"));
				String newDateString = df.format(startDate);
				System.out.println(newDateString);
				std.setJoinDate(startDate);
				std.setJoinDate(startDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (!StringUtils.isBlank(request.getParameter("versionId"))) {
			try {
				System.out.println("FOUND VERSION  ");
				std.setVersionId(Integer.parseInt(request.getParameter("versionId")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("NOT FOUND VERSION  ");
			std.setVersionId(1);
		}

		if (!StringUtils.isBlank(request.getParameter("leftDate"))) {
			try {
				Date endDate;
				endDate = df.parse(request.getParameter("leftDate"));
				String newDateString = df.format(endDate);
				System.out.println(newDateString);
				std.setJoinDate(endDate);
				std.setLeftDate(endDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// System.out.println(request.getParameter("joinDate"));
		// System.out.println(""+std.toString());

		System.out.println("VERSIONNNNNNNNNNNNNNNN  "+std.getVersionId());
		Student saveStd = studentService.save(std);
	
		if (saveStd != null) {
			// set action logger
			actionloggerService.setActionLogger(action, "created by" + Session.getLoggedUserId(), saveStd.getId(),
					Session.getLoggedUserId());
			return "redirect:studentprofile.htm?stdId=" + saveStd.getId() + "&" + ApplicationConstants.MESSAGE + "="
					+ ApplicationConstants.SUCCESS;
		} else {
			return "redirect:studentprofile.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
		}
		//request.getSession().getSessionContext().  
		
		
	}
}
