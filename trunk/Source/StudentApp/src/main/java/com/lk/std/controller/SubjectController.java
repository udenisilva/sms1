package com.lk.std.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lk.std.constant.ApplicationConstants;
import com.lk.std.model.Branch;
import com.lk.std.model.Grade;
import com.lk.std.model.Student;
import com.lk.std.model.Subject;
import com.lk.std.service.BranchService;
import com.lk.std.service.GradeService;
import com.lk.std.service.SubjectService;

@Controller
public class SubjectController {
	
	@Autowired 
	private BranchService branchServices;
	
	@Autowired 
	private SubjectService subjectServices;
	
	@Autowired
	private GradeService gradeService;
	
	
	  @RequestMapping(value = "/select_branch_details", method = RequestMethod.GET)
	  public ModelAndView select_branch_details(HttpServletRequest request) {
	    ModelMap modelMap = new ModelMap(); 	
	    System.out.println("LOAD SELECTD BRANCH DETAILS ");
	    List<Subject> sLi=subjectServices.findAll();
	    long branchId=0;
	    try {
			if (!StringUtils.isBlank(request.getParameter("branch_id"))) {
				branchId = Long.parseLong(request.getParameter("branch_id").trim());
			}
			if (branchId > 0) {
				sLi=subjectServices.findAllSubjectsByBranchId(branchId);
			} else {
			//	student = new Student();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	    
	    List<Branch> brLi=branchServices.findAll();
	   
	    List<Grade> grade=gradeService.findAll();
	    
	   //  List<Subject> sL2i=subjectServices.getSubjectDetails(1);
	   
	  
	     Subject s=new Subject();
	     modelMap.addAttribute("subject",s);	    
	    modelMap.addAttribute("brLi",brLi);
	    modelMap.addAttribute("brLi2",brLi);
	    modelMap.addAttribute("sLi",sLi);
	    modelMap.addAttribute("action","new");	
	    modelMap.addAttribute("grade",grade);
	    return new ModelAndView("subject", modelMap);	    
	  }
	
	
	  @RequestMapping(value = "/subject_form", method = RequestMethod.GET)
	  public ModelAndView getHomePage(HttpServletRequest request) {
	    ModelMap modelMap = new ModelMap(); 	
	    System.out.println("LOAN subject_form ");
	    
	    List<Branch> brLi=branchServices.findAll();
	    List<Subject> sLi=subjectServices.findAll();
	    List<Grade> grade=gradeService.findAll();
	    
	   //  List<Subject> sL2i=subjectServices.getSubjectDetails(1);
	   
	  
	     Subject s=new Subject();
	     s.setCode(subjectServices.generateNextSubjectCode());
	     
	     modelMap.addAttribute("subject",s);	    
	    modelMap.addAttribute("brLi",brLi);
	    modelMap.addAttribute("brLi2",brLi);
	    modelMap.addAttribute("sLi",sLi);
	    modelMap.addAttribute("action","new");	
	    modelMap.addAttribute("gradeList",grade);
	    return new ModelAndView("subject", modelMap);	    
	  }
	  
	  @RequestMapping(value = "/update_subject_details_view", method = RequestMethod.GET)
	  public ModelAndView update_subject_details_view(HttpServletRequest request,@RequestParam(value="id")int id) {
	    ModelMap modelMap = new ModelMap(); 	
	    System.out.println("update_subject_details_view Conroller");
	    
	    List<Branch> brLi=branchServices.findAll();
	    List<Subject> sLi=subjectServices.findAll();
	    
	  //  List<Subject> sL2i=subjectServices.getSubjectDetails(1);
	 
	    Subject s=subjectServices.findById(id);
	    
	    modelMap.addAttribute("action","update");	    
	    
	    modelMap.addAttribute("subject",s);	    
	    modelMap.addAttribute("brLi",brLi);
	    modelMap.addAttribute("sLi",sLi);
	    List<Grade> grade=gradeService.findAll();
	    modelMap.addAttribute("gradeList",grade);
	    
	    return new ModelAndView("subject", modelMap);
	    
	  }
	  
	  @RequestMapping(value = "/subject_form_select_branch", method = RequestMethod.GET)
	  public ModelAndView getHomePage(HttpServletRequest request,@RequestParam(value="branch_id_select")int branch_id_select) {
	    ModelMap modelMap = new ModelMap(); 	
	    System.out.println("SELECTED BRANCH ID "+branch_id_select);
	    
	    List<Branch> brLi=branchServices.findAll();
	    
	    Subject s=new Subject();
	    modelMap.addAttribute("subject",s);	    
	    modelMap.addAttribute("brLi",brLi);
	    modelMap.addAttribute("brLi2",brLi);
	    
	    return new ModelAndView("subject", modelMap);
	    
	  }
	  
	  @RequestMapping(value = "/add_subject", method = RequestMethod.POST)
	  public ModelAndView add_subject(HttpServletRequest request,@RequestParam(value="action")String action,@ModelAttribute("subject") Subject subject, BindingResult errors) {
	    ModelMap modelMap = new ModelMap();
	    System.out.println("ddddddddddddddddd  action"+action);
	    
	    System.out.println("ddddddddddddddddd  branch_id"+subject.getBranch().getId());
	    System.out.println("ddddddddddddddddd branch_id "+subject.getCode());
	    System.out.println("ddddddddddddddddd getSubject "+subject.getSubject());
	    
	    Branch br=branchServices.findById(subject.getBranch().getId());
	    

	    
	    if(action.equals("new")){	    
	    	System.out.println("NEWWWWWWWWWWWWWWWSSS  DD");
	    	
	    subject.setBranch(br);
	    subject.setVersionId(1);
	    
		    subject=subjectServices.saveSubjectDetails(subject);
		    if(subject!=null) {
		    	try{
		    			//return "redirect:subject.htm?" + ApplicationConstants.MESSAGE + "="+ ApplicationConstants.SUCCESS;
		    		modelMap.addAttribute("result","success");
		    		    List<Branch> brLi=branchServices.findAll();
		    		    List<Subject> sLi=subjectServices.findAll();
		    		    
		    		 

		    		     Subject s=new Subject();
		    		     s.setCode(subjectServices.generateNextSubjectCode());
		    		    modelMap.addAttribute("subject",s);	    
		    		    modelMap.addAttribute("brLi",brLi);
		    		    modelMap.addAttribute("brLi2",brLi);
		    		    modelMap.addAttribute("sLi",sLi);
		    		    modelMap.addAttribute("action","new");	   
		    		    List<Grade> grade=gradeService.findAll();
		    		    modelMap.addAttribute("gradeList",grade);
		    		     
		    		 
		    		 
		    		   return new ModelAndView("subject", modelMap);
			    }catch (Exception e) {
			    	modelMap.addAttribute("result","failed");
			    	   return new ModelAndView("subject", modelMap);
			    	//  return "redirect:subject.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
				}
		    }else{	
		    	modelMap.addAttribute("result","failed");
		    	   return new ModelAndView("subject", modelMap);
		    	//return "redirect:subject.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
		    }
		      
	    }else{
	    	System.out.println("UPDATETEDDDDDDDDDD DDDDD");
	    	 subject=subjectServices.saveSubjectDetails(subject);
			    if(subject!=null) {
			    	try{
			    		modelMap.addAttribute(ApplicationConstants.MESSAGE,ApplicationConstants.SUCCESS);
			    	    List<Branch> brLi=branchServices.findAll();
			    	    List<Subject> sLi=subjectServices.findAll();
			    	    
			    	 
			    	    Subject s=new Subject();
		    		     s.setCode(subjectServices.generateNextSubjectCode());
			    	    modelMap.addAttribute("subject",s);	    
			    	    modelMap.addAttribute("brLi",brLi);
			    	    modelMap.addAttribute("brLi2",brLi);
			    	    modelMap.addAttribute("sLi",sLi);
			    	    modelMap.addAttribute("action","new");	  
			    	    
			    	    List<Grade> grade=gradeService.findAll();
			    	    modelMap.addAttribute("gradeList",grade);
			    	    
			    		return new ModelAndView("subject", modelMap);
			    		//	return "redirect:subject.htm?" + ApplicationConstants.MESSAGE + "="+ ApplicationConstants.SUCCESS;
			    		
				    }catch (Exception e) {
				      	modelMap.addAttribute("result","failed");
				    	   return new ModelAndView("subject", modelMap);
				    	//  return "redirect:subject.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
					}
			    }else{
			      	modelMap.addAttribute("result","failed");
			    	   return new ModelAndView("subject", modelMap);
			    //	return "redirect:subject.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
			    }	    	
	    }
	    
	   // modelMap.addAttribute("subject",subject);
	    //return new ModelAndView("subject", modelMap);
	    
	  }
	
	
	

}
