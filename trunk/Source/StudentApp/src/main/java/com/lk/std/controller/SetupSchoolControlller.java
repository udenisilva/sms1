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
import com.lk.std.constant.OLSIMSEnumConstant.Action;
import com.lk.std.model.Branch;
import com.lk.std.model.Student;
import com.lk.std.service.ActionLoggerService;
import com.lk.std.service.BranchService;
import com.lk.std.util.Session;

@Controller
@RequestMapping
public class SetupSchoolControlller {
	
	@Autowired
	BranchService branchService;
	
	@Autowired
	ActionLoggerService actionloggerService;

	  @RequestMapping(value = "/setupschool", method = RequestMethod.GET)
	  public ModelAndView getHomePage(HttpServletRequest request) {
	    ModelMap modelMap = new ModelMap(); 
	    long branchId = 0;
		Branch branch = null;
		try {
			if (!StringUtils.isBlank(request.getParameter("branchid"))) {
				branchId = Long.parseLong(request.getParameter("branchid").trim());
			}
			if (branchId > 0) {
				branch =  branchService.findById(branchId);
				System.out.println(branchId+"");
			} else {
				branch = new Branch();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
//		modelMap.addAttribute("branch", branchService.findAll());
		modelMap.addAttribute("branch", branch);
	    return new ModelAndView("setupschool", modelMap);
	  }
	  
	  @RequestMapping(value = "/createBranch", method = RequestMethod.POST)
		public String StaffPager(HttpServletRequest request, @ModelAttribute("branch") Branch branch, BindingResult errors) {
			if (errors.hasErrors()) {
				System.out.println("------------error occured");
			}
			Action action = null;

			try {
				if (!StringUtils.isBlank(request.getParameter("id"))) {
					Long id =new Long(request.getParameter("id"));
					action = Action.USER_UPDATED;
					branch.setId(id);
				} else {
					action = Action.USER_CREATED;
				}

			} catch (Exception e) {
				System.out.println("------------ Exception occured");
			}

			Branch savebranch = branchService.save(branch);

			if (savebranch != null) {
				// set action logger
				actionloggerService.setActionLogger(action, "created by" + Session.getLoggedUserId(), savebranch.getId(),
						Session.getLoggedUserId());
				return "redirect:setupschool.htm?branchid=" + savebranch.getId() + "&" + ApplicationConstants.MESSAGE + "="
						+ ApplicationConstants.SUCCESS;
			} else {
				return "redirect:setupschool.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
			}
		}
}
