package com.lk.std.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lk.std.constant.ApplicationConstants;
import com.lk.std.constant.OLSIMSEnumConstant;
import com.lk.std.constant.GeneralEnumConstants.ApplicationType;
import com.lk.std.constant.GeneralEnumConstants.AttachmentType;
import com.lk.std.constant.GeneralEnumConstants.LanguageType;
import com.lk.std.constant.GeneralEnumConstants.YesNoStatus;
import com.lk.std.service.DistrictSecretariatService;
import com.lk.std.service.DistrictService;
import com.lk.std.service.GramaNiladhariDivisionService;
import com.lk.std.service.LocalAuthorityService;
import com.lk.std.service.SequenceNumberService;
import com.lk.std.service.SystemUserService; 
import com.lk.std.util.LanguageUtil;
import com.lk.std.util.Session;

import com.lk.std.model.District;
import com.lk.std.model.DistrictSecretariat;
import com.lk.std.model.GramaNiladhariDivision; 
import com.lk.std.model.LocalAuthority;
import com.lk.std.model.SystemUser; 



@Controller
public class ApplicationController {


  @Autowired
  DistrictService districtService;

  @Autowired
  DistrictSecretariatService districtSecretariatService;

  @Autowired
  GramaNiladhariDivisionService gramaNiladhariDivisionService;

  @Autowired
  LocalAuthorityService localAuthorityService;
 

  @Autowired
  SequenceNumberService sequenceNumberService;
 

 

  @Autowired
  SystemUserService systemUserService;

 

  @RequestMapping(value = "/changeLanguage", method = RequestMethod.GET)
  public @ResponseBody String changeLanguage(HttpServletRequest request, HttpServletResponse response,@RequestParam("langType") String langType) {
	  HttpSession session = request.getSession();
    Session.setApplicationLanguage(langType);
    session.setAttribute("SESSION_APP_LANG", langType);
    System.out.println(Session.getApplicationLanguage());
    return langType;
  }



}
