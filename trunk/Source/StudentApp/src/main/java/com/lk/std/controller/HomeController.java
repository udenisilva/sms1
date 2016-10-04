package com.lk.std.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lk.std.constant.ApplicationConstants;
import com.lk.std.constant.GeneralEnumConstants;
import com.lk.std.constant.OLSIMSEnumConstant;
import com.lk.std.service.ActionLoggerService;
import com.lk.std.service.SystemUserService;
import com.lk.std.util.DateUtil;
import com.lk.std.util.Session;

import com.lk.std.model.SystemUser;

@Controller
public class HomeController { 

  @Autowired
  SystemUserService systemUserService;
 

  @Autowired
  ActionLoggerService actionLoggerService;


  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public ModelAndView getHomePage(HttpServletRequest request) {
    ModelMap modelMap = new ModelMap();
    Session.setApplicationRefNo("");
 
    return new ModelAndView("home", modelMap);
  }


  @RequestMapping(value = "/applicationHome", method = RequestMethod.GET)
  public ModelAndView getApplicationHomePage(HttpServletRequest request) {
    Session.setApplicationRefNo("");
//    Session.setApplicationLanguage("en");
    ModelMap modelMap = new ModelMap();
    modelMap.put("message", "Hi");

    return new ModelAndView("applicationHome", modelMap);
  }


  
}
