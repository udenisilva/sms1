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
import com.lk.std.dto.AttendanceDto;
import com.lk.std.model.Attendance;
import com.lk.std.model.Branch;
import com.lk.std.model.Grade;
import com.lk.std.model.Staff;
import com.lk.std.model.Student;
import com.lk.std.service.AttendanceService;
import com.lk.std.service.BranchService;
import com.lk.std.service.GradeService;
import com.lk.std.service.StudentService;
import com.lk.std.util.Session;

@Controller
@RequestMapping
public class StudentAttendanceController {

	@Autowired
	GradeService gradeService;

	@Autowired
	AttendanceService attendanceService;

	@Autowired
	BranchService branchService;

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/studentattendance", method = RequestMethod.GET)
	public ModelAndView getStudentAttendance(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		long gradeId = 0;
		long branchId = 0;
		List<Grade> grades = null;
		List<Student> students = null;
		List<Attendance> attendance = null;
		modelMap.addAttribute("branchs", branchService.findAll());
		try {
			if (!StringUtils.isBlank(request.getParameter("branchId"))) {
				branchId = Long.parseLong(request.getParameter("branchId").trim());
			}
			if (branchId > 0) {
				Branch branch = branchService.findById(branchId);
				grades = gradeService.findByBranch(branch);
				modelMap.addAttribute("branchId", branchId);
				System.out.println("grade " + grades.size() + " " + grades.get(0).getId());
			} else {
				grades = new ArrayList<>();
			}
		} catch (Exception e) {
		}

		try {
			if (!StringUtils.isBlank(request.getParameter("gradeId"))) {
				gradeId = Long.parseLong(request.getParameter("gradeId").trim());
			}
			if (gradeId > 0) {
				
				modelMap.addAttribute("check",1);
				Grade grade = gradeService.findById(gradeId);
				students = studentService.findByGrade(grade);
				modelMap.addAttribute("gradeId", gradeId);
				System.out.println(students.size());
				System.out.println("student " + students.get(0).getName());

				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

				if (!StringUtils.isBlank(request.getParameter("date"))) {
					Date bDate;
					modelMap.addAttribute("check",2);
					bDate = df.parse(request.getParameter("date"));
					String newDateString = df.format(bDate);
					System.out.println(newDateString);

					attendance = attendanceService.findByGradeAndAttDate(grade, bDate);
					System.out.println(attendance.size() + " size att");
					int count = 0;
					for (Attendance att : attendance) {
						System.out.println(att.getAttDate() + " aa======");
						count=1;
					}
					
					if(count==0){
						modelMap.addAttribute("attendances", attendance);
						modelMap.addAttribute("check",1);
					}else{
						modelMap.addAttribute("check",2);
						modelMap.addAttribute("attendances", attendance);
					}
					modelMap.addAttribute("datez", request.getParameter("date"));
					

				}

			} else {
				attendance = new ArrayList<>();
				students = new ArrayList<>();
			}
		} catch (Exception e) {
		}

		modelMap.addAttribute("status", OLSIMSEnumConstant.AttendanceStatus.values());
		modelMap.addAttribute("grades", grades);
		modelMap.addAttribute("students", students);
		return new ModelAndView("studentattendance", modelMap);
	}

	@RequestMapping(value = "/addattendance", method = RequestMethod.POST)
	public String StaffPager(HttpServletRequest request, @ModelAttribute("attendancea") AttendanceDto attendanceDto,
			BindingResult errors) {
		if (errors.hasErrors()) {
			System.out.println("------------error occured");
		}
		// Staff staff2=null;
		Action action = null;

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		if (!StringUtils.isBlank(request.getParameter("date"))) {
			try {
				Date startDate;
				startDate = df.parse(request.getParameter("date"));
				String newDateString = df.format(startDate);
				System.out.println(newDateString);
				attendanceDto.setDate(startDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			if (!StringUtils.isBlank(request.getParameter("staff_id"))) {
				// staff2=staffService.findById(staff.getId());
				action = Action.USER_UPDATED;
			} else {
				// staff2=new Staff();
				action = Action.USER_CREATED;
			}

		} catch (Exception e) {
			System.out.println("------------ Exception occured");
		}

		List<Attendance> attendance = attendanceService.findByGradeAndAttDate(attendanceDto.getGrade(),
				attendanceDto.getDate());

		for (Attendance att : attendance) {
			attendanceService.delete(att);
		}

		for (Attendance att : attendanceDto.getAttendance()) {
			System.out.println(attendanceDto.getDate() + " date");
			att.setAttDate(attendanceDto.getDate());
			att.setGrade(attendanceDto.getGrade());
			attendanceService.save(att);
		}

		// if (saveStaff != null) {
		// // set action logger
		// actionloggerService.setActionLogger(action, "created by" +
		// Session.getLoggedUserId(), saveStaff.getId(),
		// Session.getLoggedUserId());
		// return "redirect:staffprofile.htm?staffId=" + saveStaff.getId() + "&"
		// + ApplicationConstants.MESSAGE + "="
		// + ApplicationConstants.SUCCESS;
		// } else {
		return "redirect:studentattendance.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
		// }
	}

}
