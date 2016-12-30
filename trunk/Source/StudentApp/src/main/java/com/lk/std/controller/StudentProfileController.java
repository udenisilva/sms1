package com.lk.std.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
				student = studentService.findById(stdId);
			} else {
				student = new Student();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		modelMap.addAttribute("branchs", branchService.findAll());
		for (int i = 1; i < branchService.findAll().size(); i++) {
			System.out.println(branchService.findAll().get(i).getCode());
		}
		modelMap.addAttribute("genders", OLSIMSEnumConstant.Gender.values());
		modelMap.addAttribute("grade", gradeService.findAll());
		modelMap.addAttribute("student", student);
		modelMap.addAttribute("status", OLSIMSEnumConstant.ActiveStatus.values());

		return new ModelAndView("studentprofile", modelMap);
	}

	@RequestMapping(value = "/createStudent", method = RequestMethod.POST)
	public String StaffPager(HttpServletRequest request, @ModelAttribute("student") Student std, BindingResult errors) {
		if (errors.hasErrors()) {
			System.out.println("------------error occured");
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
