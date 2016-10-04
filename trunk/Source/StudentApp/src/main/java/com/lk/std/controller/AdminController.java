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
public class AdminController {

  @RequestMapping(value = "/adminHome", method = RequestMethod.GET)
  public String getAdminHomePage(HttpServletRequest request) {
    return "adminHome";
  }


  @RequestMapping(value = "/createUser", method = RequestMethod.GET)
  public ModelAndView getCreateUserPage(HttpServletRequest request) {
    ModelMap map = new ModelMap();
    Session.setApplicationRefNo("");
//    Session.setApplicationLanguage("en");
    map.put("systemUser", Session.getSystemUser());
//    Session.setApplicationLanguage("en");
    return new ModelAndView("createUser");
  }



}
