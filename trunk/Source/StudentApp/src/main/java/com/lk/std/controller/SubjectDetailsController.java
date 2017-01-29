package com.lk.std.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lk.std.model.Branch;
import com.lk.std.model.ClassSchedule;
import com.lk.std.model.Grade;
import com.lk.std.model.Staff;
import com.lk.std.model.Student;
import com.lk.std.model.Subject;
import com.lk.std.service.BranchService;
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
	
	@Autowired
	BranchService branchService;
	
	  @RequestMapping(value = "/subjectdetails", method = RequestMethod.GET)
	  public ModelAndView getHomePage(HttpServletRequest request) {
	    ModelMap modelMap = new ModelMap(); 
	    
	    long branchId=0;
	    long gradeId=0;
	    long subjectId=0;
	    
	    List<Branch> branchList=new ArrayList<Branch>();
	    List<Grade> gradeList=new ArrayList<Grade>();
	    List<Staff> staffList=new ArrayList<Staff>();
	 
	    if (!StringUtils.isBlank(request.getParameter("branch"))) {
	    	branchId = Long.parseLong(request.getParameter("branch").trim());
	    
	    	Branch branch=branchService.findById(branchId);
	    	
	    	branchList.add(branch);
    		branchList= branchService.findAll();
	    	modelMap.addAttribute("branchList", branchList);
	    	System.out.println("111111111111111111");
	    	
	    	staffList=staffService.findAllByBranch(branch);
	    	modelMap.addAttribute("teacherList", staffList);
	    	
	    	if(!StringUtils.isBlank(request.getParameter("grade_id"))){
	    		gradeId = Long.parseLong(request.getParameter("grade_id").trim());
	    		
	    		branchList.add(branch);
	    		branchList= branchService.findAll();
		    	modelMap.addAttribute("branchList", branchList);
		    	
		    	System.out.println("2222222222222222222");
		   	 	modelMap.addAttribute("exists",2); 
		    	Grade grade=gradeService.findById(gradeId);
		    	modelMap.addAttribute("grade",grade); 
		    	//gradeList.add(grade);
		    	gradeList= gradeService.findByBranch(branch);
		    	//gradeList.add(grade);
	    	  	modelMap.addAttribute("gradeList", gradeList); 	    	
	    		modelMap.addAttribute("subjectList", subjectService.findByBranchIdAndGradeId(branchId, gradeId)); 
	    		
	    		
	    		if(!StringUtils.isBlank(request.getParameter("subject_id"))){
	    			subjectId = Long.parseLong(request.getParameter("subject_id").trim());
	    			System.out.println("33333333333333333333");
	    			Subject subject=subjectService.findById(subjectId);
	    			modelMap.addAttribute("staff",1);
	    			modelMap.addAttribute("staffList", staffService.findAllBySubject(subject)); 
		    		
		    		
	    		}
	    		
	    		
	    		
	    		
	    	}else{
	    		
	    		gradeList= gradeService.findByBranch(branch);
	    	  	modelMap.addAttribute("gradeList", gradeList); 
	    		System.out.println("4444444444444444444444444");
	    	}
	    	
	    	//
	    
	    }else{
	   	 modelMap.addAttribute("exists", 1); 
	    		branchList= branchService.findAll();
	    	 modelMap.addAttribute("branchList", branchList); 
	    		System.out.println("555555555555555555555555");
	    	
	    //	modelMap.addAttribute("gradeList", gradeService.findAll()); 
	    	//modelMap.addAttribute("subjectList", subjectService.findAll()); 
	    }
	    
	   
	    

	    return new ModelAndView("subjectdetails", modelMap);
	    
	  }
	  
	  @RequestMapping(value = "/add_staff_to_subject", method = RequestMethod.POST)
	  public ModelAndView add_staff_to_subject(HttpServletRequest request) {
	    ModelMap modelMap = new ModelMap(); 
	    
	    long branchId=0;
	    long gradeId=0;
	    long subjectId=0;
	    long staff_id=0;
	    
	    List<Branch> branchList=new ArrayList<Branch>();
	    List<Grade> gradeList=new ArrayList<Grade>();
	    List<Staff> staffList=new ArrayList<Staff>();
	 
	    if (!StringUtils.isBlank(request.getParameter("branch"))) {
	    	branchId = Long.parseLong(request.getParameter("branch").trim());
	    	
	    }
	    
		if(!StringUtils.isBlank(request.getParameter("grade_id"))){
    		gradeId = Long.parseLong(request.getParameter("grade_id").trim());
		}
		
		if(!StringUtils.isBlank(request.getParameter("subject_id"))){
			subjectId = Long.parseLong(request.getParameter("subject_id").trim());
		}
		
		if(!StringUtils.isBlank(request.getParameter("staff_id"))){
			staff_id = Long.parseLong(request.getParameter("staff_id").trim());
		}
		
		Staff staff=staffService.findById(staff_id);
		
		List<Subject> subjectList=new ArrayList<Subject>();
		Subject sub=subjectService.findById(subjectId);
		
		subjectList.add(sub);
		staff.setSubjects(subjectList);
		
		staff=staffService.save(staff);
		if(staff!=null){
			
			modelMap.addAttribute("result", "added");
		}else{
			
			modelMap.addAttribute("result", "failed");
		}
	    
		modelMap.addAttribute("exists", 1); 
 		branchList= branchService.findAll();
 		modelMap.addAttribute("branchList", branchList); 
	    
	    
	   
	    

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
