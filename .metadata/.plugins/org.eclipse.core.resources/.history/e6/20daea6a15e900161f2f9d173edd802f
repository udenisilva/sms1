package com.lk.std.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lk.std.constant.ApplicationConstants;
import com.lk.std.constant.GeneralEnumConstants;
import com.lk.std.constant.OLSIMSEnumConstant;
import com.lk.std.constant.GeneralEnumConstants.UserRoleType;
import com.lk.std.constant.OLSIMSEnumConstant.Action;
import com.lk.std.dto.HostingForm;
import com.lk.std.model.Branch;
import com.lk.std.model.Parents;
import com.lk.std.model.Student;
import com.lk.std.model.SystemUser;
import com.lk.std.model.UserRole;
import com.lk.std.service.ActionLoggerService;
import com.lk.std.service.ParentsService;
import com.lk.std.service.StudentService;
import com.lk.std.service.SystemUserService;
import com.lk.std.util.Session;

@Controller
@RequestMapping
public class ParentDetailsController {

	@Autowired
	ParentsService parentService;

	@Autowired
	StudentService studentService;

	@Autowired
	ActionLoggerService actionloggerService;
	
	@Autowired
	  private SystemUserService systemUserService;
	


	@RequestMapping(value = "/parentdetails", method = RequestMethod.GET)
	public ModelAndView getHomePage(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		long studentId = 0;
		Parents parent = null;
		try {
			if (!StringUtils.isBlank(request.getParameter("student_id"))) {
				studentId = Long.parseLong(request.getParameter("student_id").trim());

				System.out.println("------------error occured");
			}
			if (studentId > 0) {
				parent = parentService.findByStudent(studentService.findById(studentId)).get(0);
				modelMap.addAttribute("student_id", studentId);
			} else {
				parent = new Parents();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		Student st=new Student();
		st.setId(0);
		
		modelMap.addAttribute("student", st);
		modelMap.addAttribute("parent", parent);
		modelMap.addAttribute("studentList", studentService.findAll());
		return new ModelAndView("parentdetails", modelMap);
	}
	
	@RequestMapping(value = "/select_student_to_add_parent", method = RequestMethod.GET)
	public ModelAndView select_student_to_add_parent(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		long studentId = 0;
		Parents parent = null;
		Student student=new Student();
	
		try {
			if (!StringUtils.isBlank(request.getParameter("id"))) {
				studentId = Long.parseLong(request.getParameter("id").trim());

				System.out.println("------------error occured");
			}
			if (studentId > 0) {
				student = studentService.findById(studentId);
				
				if(student!=null){
					parent=parentService.findById(student.getParents().getId());
				}else{
					parent.setVersionId(1);
				}
				
			//	modelMap.addAttribute("student_id", studentId);
			} else {
				parent = new Parents();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
		modelMap.addAttribute("student", student);
		modelMap.addAttribute("parent", parent);
	//	modelMap.addAttribute("studentList", studentService.findAll());
		return new ModelAndView("parentdetails", modelMap);
	}

	@RequestMapping(value = "/createParents", method = RequestMethod.POST)
	public String StaffPager(HttpServletRequest request, @ModelAttribute("parents") Parents parent,
			BindingResult errors) {
		if (errors.hasErrors()) {
			System.out.println("------------error occured");
		}
		Action action = null;

		
		try {
			if (!StringUtils.isBlank(request.getParameter("parent_id"))) {
				action = Action.USER_UPDATED;
			} else {
				action = Action.USER_CREATED;
			}

		} catch (Exception e) {
			System.out.println("------------ Exception occured");
		}

		Parents saveParents = parentService.save(parent);
		Student student = studentService.findById(Long.parseLong(request.getParameter("student_id").trim()));
		student.setParents(saveParents);
		studentService.save(student);
		
		try{
		
		SystemUser systemUserF = new SystemUser();
		systemUserF.setActiveStatus(GeneralEnumConstants.YesNoStatus.YES);
		systemUserF.setUserName(parent.getFemail());
		systemUserF.setPassword(parent.getFnic());
		systemUserF.setEmailAddress(parent.getFemail());

		List<UserRole> userRolesF = new ArrayList<UserRole>();

		UserRole userRoleF = new UserRole();
		userRoleF.setUserRoleType(UserRoleType.PARENT);
		userRolesF.add(userRoleF);
		systemUserF.setUserRoles(userRolesF);
		
		systemUserService.saveSystemUser(systemUserF);
		
	
		

		SystemUser systemUserM = new SystemUser();
		systemUserM.setActiveStatus(GeneralEnumConstants.YesNoStatus.YES);
		systemUserM.setUserName(parent.getMemail());
		systemUserM.setPassword(parent.getMnic());
		systemUserM.setEmailAddress(parent.getMemail());

		List<UserRole> userRolesM = new ArrayList<UserRole>();
		UserRole userRoleM = new UserRole();
		userRoleM.setUserRoleType(UserRoleType.PARENT);
		userRolesM.add(userRoleM);
		systemUserM.setUserRoles(userRolesM);
		
	

		systemUserService.saveSystemUser(systemUserM);
		
		}catch (Exception e) {
			// TODO: handle exception
		}

		if (saveParents != null) {
			// set action logger
			actionloggerService.setActionLogger(action, "created by" + Session.getLoggedUserId(), saveParents.getId(),
					Session.getLoggedUserId());
			return "redirect:parentdetails.htm?student_id=" + saveParents.getId() + "&" + ApplicationConstants.MESSAGE
					+ "=" + ApplicationConstants.SUCCESS;
		} else {
			return "redirect:parentdetails.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
		}
	}
}
