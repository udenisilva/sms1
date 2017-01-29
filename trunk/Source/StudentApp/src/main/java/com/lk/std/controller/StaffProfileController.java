package com.lk.std.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lk.std.constant.ApplicationConstants;
import com.lk.std.constant.GeneralEnumConstants;
import com.lk.std.constant.OLSIMSEnumConstant;
import com.lk.std.constant.GeneralEnumConstants.UserRoleType;
import com.lk.std.constant.OLSIMSEnumConstant.Action;
import com.lk.std.constant.OLSIMSEnumConstant.MessagesCatagory;
import com.lk.std.dto.HostingForm;
import com.lk.std.model.Staff;
import com.lk.std.model.SystemUser;
import com.lk.std.model.UserRole;
import com.lk.std.service.ActionLoggerService;
import com.lk.std.service.BranchService;
import com.lk.std.service.DesignationService;
import com.lk.std.service.StaffService;
import com.lk.std.service.SystemUserService;
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
	
	@Autowired
	  private SystemUserService systemUserService;
	
	@RequestMapping(value = "/check_ajax",method = RequestMethod.POST)
	  @ResponseBody
	  public String  checkEmailExists(@RequestBody HostingForm hostingForm)
	  {
	
		System.out.println(" CHECK USER IS EXISTS  "+hostingForm.getEmail());
		String exists=systemUserService.validateUsername(hostingForm.getEmail());
		
		if(exists.equals("suc")) {
		
			System.out.println("  USER IS NOT EXISTS  ");		
			exists="not_exists";
		
		}else{
			exists="exists";
			System.out.println("  USER IS  EXISTS  ");
		}
	  return exists;
	 }

	@RequestMapping(value = "/staffprofile", method = RequestMethod.GET)
	public ModelAndView getStaffPage(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("branchs", branchService.findAll());
		for(int i=1; i<branchService.findAll().size();i++){			
			System.out.println(branchService.findAll().get(i).getCode());
		}
		modelMap.addAttribute("designations", designationService.findAll());
		modelMap.addAttribute("titles", OLSIMSEnumConstant.Title.values());
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
				modelMap.addAttribute("staff_id", staffService.getNextstaff_id());
			}
		} catch (Exception e) { 
		}
		
		
		modelMap.addAttribute("category", OLSIMSEnumConstant.Gender.values());
		modelMap.addAttribute("staffList", staffService.findAll());
		modelMap.addAttribute("staff", staff);
		return new ModelAndView("staffprofile", modelMap);
	}

	@RequestMapping(value = "/createStaff", method = RequestMethod.GET)
	public ModelAndView StaffPager(HttpServletRequest request, @ModelAttribute("staff") Staff staff, BindingResult errors) {
		if (errors.hasErrors()) {
			System.out.println("------------error occured");
			
		}
		ModelMap modelMap = new ModelMap();
		// Staff staff2=null;
		Action action = null;

		try {
			if (!StringUtils.isBlank(request.getParameter("staff_id"))) {
				// staff2=staffService.findById(staff.getId());
				action = Action.USER_UPDATED;
				System.out.println("------------UPDATEDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
			} else {
				// staff2=new Staff();
				action = Action.USER_CREATED;
				System.out.println("------------NEWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
			}

		} catch (Exception e) {
			System.out.println("------------ Exception occured");
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		if (!StringUtils.isBlank(request.getParameter("jdate"))) {
			try {
				Date startDate;
				startDate = df.parse(request.getParameter("jdate"));
				String newDateString = df.format(startDate);
				System.out.println(newDateString);
				staff.setJdate(startDate); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (!StringUtils.isBlank(request.getParameter("ldate"))) {
			try {
				Date endDate;
				endDate = df.parse(request.getParameter("ldate"));
				String newDateString = df.format(endDate);
				System.out.println(newDateString); 
				staff.setLdate(endDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	
		System.out.println("11111111111111 getId= "+staff.getId());
		System.out.println("11111111111111 getBranch= "+staff.getBranch().getId());
		System.out.println("11111111111111 getTitle= "+staff.getTitle());
		System.out.println("11111111111111 getName= "+staff.getName());
		System.out.println("11111111111111 getAddress= "+staff.getAddress());
		System.out.println("11111111111111 getDesignation= "+staff.getDesignation());
		System.out.println("11111111111111 getNic= "+staff.getNic());
		System.out.println("11111111111111 getTel= "+staff.getTel());
		System.out.println("11111111111111 getMobile= "+staff.getMobile());
		System.out.println("11111111111111 getEmail= "+staff.getEmail());
		System.out.println("11111111111111 getJdate= "+staff.getJdate());
		System.out.println("11111111111111 getLdate= "+staff.getLdate());
		System.out.println("11111111111111 getStatus= "+staff.getStatus());
		System.out.println("11111111111111 getGender= "+staff.getGender());

		System.out.println("11111111111111 getBday= "+staff.getBday());
		
		
		String checkUser=systemUserService.validateUsername(staff.getEmail());
		
		 /////////////// IF NOT EXISTS + USER NAME		
		
		Staff saveStaff = staffService.save(staff);
		
		if(!checkUser.equals("err")) {
			
			SystemUser systemUserM = new SystemUser();
			systemUserM.setActiveStatus(GeneralEnumConstants.YesNoStatus.YES);
			systemUserM.setUserName(staff.getEmail());
			systemUserM.setPassword(staff.getNic());
			systemUserM.setEmailAddress(staff.getEmail());
	
			List<UserRole> userRolesM = new ArrayList<UserRole>();
			UserRole userRoleM = new UserRole();
			userRoleM.setUserRoleType(UserRoleType.ROLE_USER);
			userRolesM.add(userRoleM);
			systemUserM.setUserRoles(userRolesM);

		systemUserService.saveSystemUser(systemUserM);

			if (systemUserService != null) {
				// set action logger
				actionloggerService.setActionLogger(action, "created by" + Session.getLoggedUserId(), saveStaff.getId(),
						Session.getLoggedUserId());
			
				modelMap.addAttribute("msg",ApplicationConstants.SUCCESS);
				
				modelMap.addAttribute("category", OLSIMSEnumConstant.Gender.values());
				modelMap.addAttribute("staffList", staffService.findAll());
				modelMap.addAttribute("designations", designationService.findAll());
				modelMap.addAttribute("titles", OLSIMSEnumConstant.Title.values());
				modelMap.addAttribute("status", OLSIMSEnumConstant.ActiveStatus.values());
				
				modelMap.addAttribute("staff", new Staff());
				
				return new ModelAndView("staffprofile", modelMap);
			} else {
				modelMap.addAttribute("msg",ApplicationConstants.ERROR);
				return new ModelAndView("staffprofile", modelMap);
			}
		
		}else{
			modelMap.addAttribute("msg",ApplicationConstants.EXISTS_USER_NAME);			
			return new ModelAndView("staffprofile", modelMap);
		}
	}

}
