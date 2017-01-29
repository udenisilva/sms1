package com.lk.std.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lk.std.util.Session;

@Controller
@RequestMapping
public class ClassScheduleController {

	  @RequestMapping(value = "/classschedule", method = RequestMethod.GET)
	  public ModelAndView getHomePage(HttpServletRequest request) {
	    ModelMap modelMap = new ModelMap(); 
	 
	    return new ModelAndView("classschedule", modelMap);
	  }
	  
	
}
