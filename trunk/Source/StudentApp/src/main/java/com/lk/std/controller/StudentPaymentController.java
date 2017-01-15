package com.lk.std.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.lk.std.model.Payments;
import com.lk.std.model.Student;
import com.lk.std.service.GradeService;
import com.lk.std.service.PaymentService;
import com.lk.std.service.StudentService;

@Controller
@RequestMapping
public class StudentPaymentController {
	
	@Autowired
	private PaymentService paymentservice;
	
	@Autowired
	private StudentService studentservice;

	  @RequestMapping(value = "/studentpayment", method = RequestMethod.GET)
	  public ModelAndView getHomePage(HttpServletRequest request) {
	    ModelMap modelMap = new ModelMap(); 
	 
		Payments p=new Payments();		
		modelMap.addAttribute("payment",p);
	    return new ModelAndView("studentpayment", modelMap);
	  }	  
	  
	  @RequestMapping(value = "/payment_select_student_details", method = RequestMethod.POST)
	  public ModelAndView payment_select_student_details(HttpServletRequest request,@RequestParam(value="student_id") long student_id) {
	    ModelMap modelMap = new ModelMap(); 
	    
	    System.out.println("STUDENT IDDDDD "+student_id);
	    
	  
	    
	    
	    Student student=studentservice.findById(student_id);
	    if(student!=null){
	    	
	    	try{
	    		Payments p=new Payments();
	    		
	    		List<Payments> pLi=paymentservice.findAllUsingStudentId(student_id);
	    		
	    		String pattern = "yyyy-MM-dd";
	    		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	    		String date = simpleDateFormat.format(new Date());
	    	
	    		modelMap.addAttribute("curDate",date);
	    		modelMap.addAttribute("payment",p);
	    		modelMap.addAttribute("pLi",pLi);
	    		 modelMap.addAttribute("result","Exists");
	    		modelMap.addAttribute("student",student);
	    
	    	}catch (Exception e) {
				System.out.println("EORRRRRRRRRRRRRRR");
			}
	    return new ModelAndView("studentpayment", modelMap);
	    }else{
	    	
	    	Payments p=new Payments();
    		
    		modelMap.addAttribute("payment",p);
	    modelMap.addAttribute("result","NOT_Exists");
	    return new ModelAndView("studentpayment", modelMap);
	    }
	    
	  }
	  
	  @RequestMapping(value = "/student_payment_new", method = RequestMethod.POST)
	  public ModelAndView student_payment_new(HttpServletRequest request,@RequestParam(value="student_id") long student_id,
			  @RequestParam(value="academicyear") int academicyear,@RequestParam(value="paymentType") String paymentType,
			  @RequestParam(value="amount") double amount,@RequestParam(value="paymentDate") String paymentDate) {
		  
		  Payments payment=new Payments();
		  
		  
	    ModelMap modelMap = new ModelMap(); 
	    
	    
	    List<Payments> pLi=paymentservice.findAllUsingStudentId(student_id);
	    
	    payment.setAcademicyear(academicyear);
	    payment.setAmount(amount);
	    payment.setPaymentType(paymentType);
	    payment.setPaymentDate(new Date());
	    payment.setVersionId(1);
	    Student st=studentservice.findById(student_id);
	    payment.setStudent(st);
	    
	    System.out.println("1111111111111111111111");	    
	    Payments added=paymentservice.savePaymet(payment);
	    
	    if(added!=null){
	    	System.out.println("2222222222");
	    	modelMap.addAttribute("result","added");
	    	Payments p2=new Payments();
	    	modelMap.addAttribute(ApplicationConstants.MESSAGE,ApplicationConstants.SUCCESS);
	    	modelMap.addAttribute("payment",p2);
	    }else{
	    	System.out.println("333333333333333");
	    	modelMap.addAttribute("result","failed");
	    	modelMap.addAttribute(ApplicationConstants.MESSAGE,ApplicationConstants.ERROR);
	    	modelMap.addAttribute("payment",payment);
	    }
	    
	    modelMap.addAttribute("pLi",pLi);	    
	    System.out.println("44444444444444444");
	    return new ModelAndView("studentpayment", modelMap);
	    
	   
	  }
	  
	  @RequestMapping(value = "/remove_student_payment_details", method = RequestMethod.GET)
	  public ModelAndView remove_student_payment_details(HttpServletRequest request,@RequestParam(value="paymentId") long paymentId,@RequestParam(value="studentId") long studentId) {
	    ModelMap modelMap = new ModelMap(); 
	    
	    
	    int delete=paymentservice.removePayment(paymentId, studentId);
	    List<Payments> pLi=paymentservice.findAllUsingStudentId(studentId);
    	
  	  	Student student=studentservice.findById(studentId);
  	  	modelMap.addAttribute("student",student);
  	  	modelMap.addAttribute("pLi",pLi);	    
	    
	    if(delete>0){		    		
	    	modelMap.addAttribute("result","removed");	    	  
	    }else{
	    	modelMap.addAttribute("result","removed_failed");
	    }
	    
	    return new ModelAndView("studentpayment", modelMap);
	  }
}
