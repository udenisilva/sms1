package com.lk.std.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lk.std.model.Grade;
import com.lk.std.model.Staff;
import com.lk.std.model.Subject;
import com.lk.std.service.GradeService;
import com.lk.std.service.StaffService;
import com.lk.std.service.SubjectService;

@Controller
@RequestMapping
public class SubjectDetailsController {

	@Autowired
	GradeService gradeService;
	
	@Autowired
	SubjectService subjectService;
	
	@Autowired
	StaffService staffService;
	
	  @RequestMapping(value = "/subjectdetails", method = RequestMethod.GET)
	  public ModelAndView getHomePage(HttpServletRequest request) {
	    ModelMap modelMap = new ModelMap(); 	 
	    List<Grade> asd= gradeService.findAll(); 
	    List<Staff> staff=staffService.findAll(); 
//	    List<Subject> subjects=subjectService.findAll(); 
	    modelMap.addAttribute("grade", gradeService.findAll()); 
	    modelMap.addAttribute("staff", staffService.findAll()); 
//	    modelMap.addAttribute("subject", subjectService.findAll());
	    return new ModelAndView("subjectdetails", modelMap);
	    
	  }
	  
	  @RequestMapping(value = "/getGradeSubject", method = RequestMethod.POST)
	  public @ResponseBody String getUserDesignation(@RequestParam("gradeId") Long gradeId) {
	    System.out.println("-------------------------------------- " + gradeId);
	    try {
	      return subjectService.findByGrade(gradeService.findById(gradeId)).toString();
	    } catch (Exception e) {
	      e.printStackTrace();
	      return null;
	    }
	  }
}
