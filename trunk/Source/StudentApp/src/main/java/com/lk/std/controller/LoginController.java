package com.lk.std.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lk.std.util.Session;

@Controller
public class LoginController {

  @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
  public ModelAndView getLoginPage(HttpServletRequest request) {
    ModelMap modelMap = new ModelMap();
    System.out.println("CAME IN TO CONTROLER");
//    Session.setApplicationLanguage("en");
    return new ModelAndView("login", modelMap);
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
//    Session.setApplicationLanguage("en");
    return "redirect:/userLogin.htm";// You can redirect wherever you want, but generally it's a
                                     // good practice to show login screen again.
  }

}
