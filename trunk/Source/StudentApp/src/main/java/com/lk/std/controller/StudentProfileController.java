package com.lk.std.controller;

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
import com.lk.std.model.Staff;
import com.lk.std.model.Student;
import com.lk.std.service.ActionLoggerService;
import com.lk.std.service.BranchService;
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
	private ActionLoggerService actionloggerService;

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
				student =  studentService.findById(stdId);
			} else {
				student = new Student();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		modelMap.addAttribute("branch", branchService.findAll());
		modelMap.addAttribute("gender", OLSIMSEnumConstant.Gender.values());
		modelMap.addAttribute("grade", gradeService.findAll());
		modelMap.addAttribute("status", OLSIMSEnumConstant.ActiveStatus.values());

		return new ModelAndView("studentprofile", modelMap);
	}
	
	@RequestMapping(value = "/createStudent", method = RequestMethod.POST)
	public String StaffPager(HttpServletRequest request, @ModelAttribute("student") Student std, BindingResult errors) {
		if (errors.hasErrors()) {
			System.out.println("------------error occured");
		}
		Action action = null;

		try {
			if (!StringUtils.isBlank(request.getParameter("std_id"))) {
				action = Action.USER_UPDATED;
			} else {
				action = Action.USER_CREATED;
			}

		} catch (Exception e) {
			System.out.println("------------ Exception occured");
		}

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
	}
}
