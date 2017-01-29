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
import org.springframework.web.bind.annotation.RequestParam;
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
	  public ModelAndView getHomePage(HttpServletRequest request ) {
	    ModelMap modelMap = new ModelMap(); 
	    long id=0;
	    
	    System.out.println("getHomePage 11111111111");
	 //   System.out.println("NEXT IDDDDDDDD  "+branchService.nextBranchId());
	    
	    try {
	    if (!StringUtils.isBlank(request.getParameter("setupid"))) {
	    	id= Long.parseLong(request.getParameter("setupid").trim());
	    	System.out.println("getHomePage 222222222222");
	      }
	    
	    if(id>0){
	    	Branch branch=new Branch();
	    	System.out.println("BRANCH ID "+id);
	    	System.out.println("getHomePage 333333333333");
	    	branch = branchService.findById(id);
	    	System.out.println("branch getCode "+branch.getCode());
	    	System.out.println("branch getAddress "+branch.getAddress());
	    	modelMap.addAttribute("msg","Update Branch Details");
	    	modelMap.addAttribute("branch",branch);
	    
	    }else{
	    	System.out.println("getHomePage 444444444444");
	    	Branch branch=new Branch();
	    	//branch.setId(0);
	    	modelMap.addAttribute("msg","Add New Branch");
	    	branch.setId(branchService.nextBranchId());
	    	branch.setCode(branchService.nextBranchCode());
	    	modelMap.addAttribute("branch",branch);
	    }
	    }catch (Exception e) {
	    	System.out.println("errrrrrrrrrrrrrrrrr ");
	    	e.printStackTrace();
		}
	    
	  
	 
	    modelMap.addAttribute("brLi",branchService.findAll());
	 
	    return new ModelAndView("setupschool", modelMap);
	  }

	  @RequestMapping(value = "/findBranch", method = RequestMethod.POST)
	  public String findRegisteredBranch(@RequestParam("forwardId") long id, HttpServletRequest request) {
	    try {
	      if (id > 0) {
	        return "redirect:setupschool.htm?setupid=" + id + "&" + ApplicationConstants.MESSAGE + "="
	            + ApplicationConstants.SUCCESS;
	      } else {
	        return "redirect:setupschool.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
	      }
	    } catch (Exception e) {
	      return "redirect:setupschool.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
	    }
	  }


	  
	  @RequestMapping(value = "/add_school_details", method = RequestMethod.GET)
	  public String add_school_details(HttpServletRequest request,@ModelAttribute("branch") Branch branch, BindingResult errors) {
	    ModelMap modelMap = new ModelMap(); 
	    
	    System.out.println("add_school_details 111111111");
	    
	    Action action = null;
	    Branch newBranch=new Branch();	    		
	    
	    if(errors.hasErrors()){
	    	
	    System.out.println("ERROR EXISTS");
	    }
	    

	    try{
	    
	    	System.out.println("/////////////// "+request.getParameter("setupid"));
	    	int setupid=Integer.parseInt(request.getParameter("setupid"));
	    	
	   // if(setupid>0){
	    	System.out.println("add_school_details 222222222222222");
	    	newBranch=branchService.findById(Long.parseLong(request.getParameter("setupid")));
	    	if(newBranch!=null) {
	    	
	    	newBranch.setCode(branch.getAddress());
	    	newBranch.setName(branch.getName());
	    	newBranch.setAddress(branch.getAddress());
	    	newBranch.setTel(branch.getTel());
	    	newBranch.setFax(branch.getFax());
	    	newBranch.setEmail(branch.getEmail());
	    	newBranch.setVersionId(branch.getVersionId());
	    	action = Action.USER_UPDATED;
	    	
	    	}else{
	    		System.out.println("add_school_details 333333333333333333");
		    	   action = Action.USER_CREATED;	    	   
		    	   newBranch=branch;
		    	   newBranch.setVersionId(1);
	    		
	    	}
	    	
	        System.out.println("------------VERSIOBB IDDD "+newBranch.getVersionId());
	    
	  //  }else{	    
	    
	    	   //
	  //  }
	    
	    
	    Branch saveBranch=branchService.save(newBranch);
	    
	    if(saveBranch!=null) {
	    	try{
	    			return "redirect:setupschool.htm?" + ApplicationConstants.MESSAGE + "="+ ApplicationConstants.SUCCESS;
	    			//modelMap.addAttribute("branch",branch);
		    }catch (Exception e) {
		    	  return "redirect:setupschool.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
			}
	    }else{
	    	
	    	return "redirect:setupschool.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
	    }
	    
	    }catch (Exception e) {
	    	return "redirect:setupschool.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
		}
	    
	    
	 
	   // return new ModelAndView("setupschool", modelMap);
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
