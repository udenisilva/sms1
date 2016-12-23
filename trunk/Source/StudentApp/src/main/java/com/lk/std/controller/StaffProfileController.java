package com.lk.std.controller;

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
import com.lk.std.model.SystemUser;
import com.lk.std.service.ActionLoggerService;
import com.lk.std.service.BranchService;
import com.lk.std.service.DesignationService;
import com.lk.std.service.StaffService;
import com.lk.std.util.Session;

@Controller
@RequestMapping
public class StaffProfileController {

	@Autowired
	DesignationService designationService;

	@Autowired
	BranchService branchService;

	@Autowired
	StaffService staffService;

	@Autowired
	private ActionLoggerService actionloggerService;

	@RequestMapping(value = "/staffprofile", method = RequestMethod.GET)
	public ModelAndView getStaffPage(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("branch", branchService.findAll());
		modelMap.addAttribute("designation", designationService.findAll());
		modelMap.addAttribute("titile", OLSIMSEnumConstant.Title.values());
		modelMap.addAttribute("status", OLSIMSEnumConstant.ActiveStatus.values());

		long staffId = 0;
		Staff staff = null;
		try {
			if (!StringUtils.isBlank(request.getParameter("staffId"))) {
				staffId = Long.parseLong(request.getParameter("staffId").trim());
			}
			if (staffId > 0) {
				staff = staffService.findById(staffId);
			} else {
				staff = new Staff();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		modelMap.addAttribute("staff", staff);
		return new ModelAndView("staffprofile", modelMap);
	}

	@RequestMapping(value = "/createStaff", method = RequestMethod.GET)
	public String StaffPager(HttpServletRequest request, @ModelAttribute("staff") Staff staff, BindingResult errors) {
		if (errors.hasErrors()) {
			System.out.println("------------error occured");
		}
		// Staff staff2=null;
		Action action = null;

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

		Staff saveStaff = staffService.save(staff);

		if (saveStaff != null) {
			// set action logger
			actionloggerService.setActionLogger(action, "created by" + Session.getLoggedUserId(), saveStaff.getId(),
					Session.getLoggedUserId());
			return "redirect:staffprofile.htm?userId=" + saveStaff.getId() + "&" + ApplicationConstants.MESSAGE + "="
					+ ApplicationConstants.SUCCESS;
		} else {
			return "redirect:staffprofiler.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
		}
	}

}
