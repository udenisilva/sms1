package com.lk.std.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import com.lk.std.model.Branch;
import com.lk.std.model.Grade;
import com.lk.std.model.Student;
import com.lk.std.service.ActionLoggerService;
import com.lk.std.service.BranchService;
import com.lk.std.service.GradeService;
import com.lk.std.util.Session;


@Controller

public class GradeContoller {

	
	@Autowired
	GradeService gradeService;
	
	@Autowired
	BranchService branchService;


	
	@RequestMapping(value="/grade_form",method=RequestMethod.GET)
	public ModelAndView view_grade_form(HttpServletRequest request){
		ModelMap modelMap = new ModelMap();	
		System.out.println("LOGGING GRADE FORM");
		modelMap.addAttribute("branchList", branchService.findAll());	
		
		
		
		return new ModelAndView("gradeNew", modelMap);
	}
	
	@RequestMapping(value="/select_branch_to_grade",method=RequestMethod.POST)
	public ModelAndView select_branch_to_grade(HttpServletRequest request){
		ModelMap modelMap = new ModelMap();	
		System.out.println("SELECT BRANCH TO GRADE");
		
		long branchId=Long.parseLong(request.getParameter("branchId"));
		Branch branch=branchService.findById(branchId);
		
	
		
		Grade grade=new Grade();
		grade.setBranch(branch);
		grade.setVersionId(1);
		
		modelMap.addAttribute("branchList", branchService.findAll());	
		
		List<Grade>gradeList=gradeService.findAll();
		modelMap.addAttribute("gradeList", gradeList);	
		
		modelMap.addAttribute("Grade", grade);	
		modelMap.addAttribute("msg", "Add new Grade");	
		
		
		
		return new ModelAndView("gradeNew", modelMap);
	}
	
	@RequestMapping(value = "/add_grade", method = RequestMethod.POST)
	public ModelAndView add_grade(HttpServletRequest request, @ModelAttribute("Grade") Grade std, BindingResult errors) {
		
		ModelMap modelMap = new ModelMap();	
		System.out.println("Add BRANCH TO GRADE");
		
		if (!errors.hasErrors()) {
			System.out.println("------------error occured");
		
		}else{
			System.out.println("errrrrrrrrrrrr "+errors);
			//return "redirect:studentprofile.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
			
		}
		Action action = null;
		
		int checkGrade=gradeService.findByGradeAndId(std.getGrade(), std.getBranch().getId());
		

		System.out.println("VERSIONNNNNNNNNNNNNNNN  "+std.getVersionId());
		
		if(checkGrade!=1){
		
		Grade saveStd = gradeService.save(std);
		
			if (saveStd != null) {		
				modelMap.addAttribute("result", "add");	
				List<Grade>gradeList=gradeService.findAll();
				modelMap.addAttribute("gradeList", gradeList);	
			
			} else {
				modelMap.addAttribute("result", "failed");	
			}
		}else{
			modelMap.addAttribute("result", "exists");	
			
		}
		modelMap.addAttribute("branchList", branchService.findAll());	
		return new ModelAndView("gradeNew", modelMap);
		
		
	}
	

	@RequestMapping(value="/remove_grade_details",method=RequestMethod.GET)
	public ModelAndView remove_grade(HttpServletRequest request){
		ModelMap modelMap = new ModelMap();	
		System.out.println("REMOVE BRANCH TO GRADE");
		
		long branchId=Long.parseLong(request.getParameter("branch_id"));
		Branch branch=branchService.findById(branchId);
		
		
		long grade_id=Long.parseLong(request.getParameter("grade_id"));	
		Grade g=gradeService.findById(grade_id);
		
		int result=gradeService.remove(g);
		
		if(result>0){		
			
			modelMap.addAttribute("result", "deleted");	
		}else{
			
			modelMap.addAttribute("result", "failed");	
		}	
					
		modelMap.addAttribute("branchList", branchService.findAll());	
		modelMap.addAttribute("msg", "Add new Grade");	
		return new ModelAndView("gradeNew", modelMap);
	}
	

	
	
	
}
