package com.lk.std.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lk.std.model.Grade;
import com.lk.std.model.Messages;
import com.lk.std.service.GradeService;
import com.lk.std.service.MessageService;

@Controller
@RequestMapping
public class MessageController {
	
	@Autowired
	private GradeService gradeservice;
	
	@Autowired
	private MessageService msgservice;

	  @RequestMapping(value = "/message", method = RequestMethod.GET)
	  public ModelAndView getHomePage(HttpServletRequest request) {
	    ModelMap modelMap = new ModelMap(); 
	    
	    List<Grade> grLi=gradeservice.findAll();
	    
	    List<Messages> msLi=msgservice.findAll();
	    
	    Messages m=new Messages();
	  //  m.setGrade(grade);
	    
	    
	    modelMap.addAttribute("message", m);	
	    
	    modelMap.addAttribute("grLi", grLi);
	    modelMap.addAttribute("msLi", msLi);	 
	    return new ModelAndView("message", modelMap);
	  }
	  
	  @RequestMapping(value = "/select_grade", method = RequestMethod.GET)
	  public ModelAndView view_grade(HttpServletRequest request,@RequestParam(value="grade_id") int grade_id) {
	    ModelMap modelMap = new ModelMap(); 
	    
	    List<Grade> grLi=gradeservice.findAll();
	    
	    Grade grade=gradeservice.findById(grade_id);
	    Messages m=new Messages();
	    m.setGrade(grade);
	    
	    
	    List<Messages> mesLi=msgservice.findAllMessageInGrade(grade_id);
	    
	    modelMap.addAttribute("msLi", mesLi);	
	    modelMap.addAttribute("action", "new");	
	    modelMap.addAttribute("message", m);	
	    modelMap.addAttribute("grLi", grLi);	 
	    return new ModelAndView("message", modelMap);
	  }
	  
	  
	  @RequestMapping(value = "/add_or_update_grade", method = RequestMethod.GET)
	  public ModelAndView add_new_grade(HttpServletRequest request,@RequestParam(value="grade_id") int grade_id,
			  @RequestParam(value="action") String action,@RequestParam(value="message_no") int message_no,
			  @RequestParam(value="message_title") String message_title,@RequestParam(value="message") String message) {
	    ModelMap modelMap = new ModelMap(); 
	    
	    System.out.println("1111111111111111111");
	 
	    List<Grade> grLi=gradeservice.findAll();
	    try{
	    Grade grade=gradeservice.findById(grade_id);
	    Messages m=new Messages();
	    m.setGrade(grade);	    
	    m.setMessage_titles(message_title);
	    m.setMessage(message);
	    
	    List<Messages> msLi=msgservice.findAll();
	    
	    if(action.equals("new")){
	    	
	    	try{
	    	
	    	m.setVersionId(1);    
	    	m.setId(1);
	    	m=msgservice.saveMessage(m);   
	    	
	    	modelMap.addAttribute("result", "add_new");	
	    	}catch (Exception exxx) {	    		
	    		modelMap.addAttribute("result", "not_added");	
			}
	    	
	    	Messages sss=new Messages();
	    	modelMap.addAttribute("message", sss);	
	        modelMap.addAttribute("grLi", grLi);	 
	        modelMap.addAttribute("msLi", msLi);	
		    return new ModelAndView("message", modelMap);
	    	
	    }else{
	    	modelMap.addAttribute("result", "update_new");
	    	 modelMap.addAttribute("message", m);	
	 	    modelMap.addAttribute("grLi", grLi);
	 	   modelMap.addAttribute("msLi", msLi);	
	 	    return new ModelAndView("message", modelMap);
	    	
	    }
	    
		}catch (Exception exxx) {	   
			
			System.out.println("22222222222222222222");
			
    		modelMap.addAttribute("result", "check_grade_added");	
    		  Messages m=new Messages();
    	 	 modelMap.addAttribute("message", m);	
 	 	    modelMap.addAttribute("grLi", grLi);	 
 	 	    return new ModelAndView("message", modelMap);
		}
	     
	   
	  }
	  
	  @RequestMapping(value = "/remove_message", method = RequestMethod.GET)
	  public ModelAndView remove_message(HttpServletRequest request,@RequestParam(value="grade_id") int grade_id,
			  @RequestParam(value="msg_id") int msg_id) {
	    ModelMap modelMap = new ModelMap(); 
	    List<Grade> grLi=gradeservice.findAll();
	    
	    int dele=msgservice.deleteMessageByMessageIdAndGradeId(msg_id,grade_id);   
	    
	    List<Messages> msLi=msgservice.findAll();
	    
	    Messages m=new Messages();
	  //  m.setGrade(grade);
	    
	    
	    modelMap.addAttribute("message", m);	
	    
	    modelMap.addAttribute("grLi", grLi);
	    modelMap.addAttribute("msLi", msLi);	
	    return new ModelAndView("message", modelMap);
	  }
	  
}
