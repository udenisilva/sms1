package com.lk.std.controller;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lk.std.constant.ApplicationConstants;
import com.lk.std.constant.GeneralEnumConstants.UserRoleType;
import com.lk.std.constant.GeneralEnumConstants.YesNoStatus;
import com.lk.std.constant.OLSIMSEnumConstant.Action;
import com.lk.std.service.ActionLoggerService;
import com.lk.std.service.DistrictService;
import com.lk.std.service.SystemUserService;
import com.lk.std.util.Session;

import com.lk.std.model.District;
import com.lk.std.model.SystemUser;
import com.lk.std.model.UserRole;

@Controller
public class UserController {

  @Autowired
  private SystemUserService systemUserService;

  @Autowired
  private DistrictService districtService;

  @Autowired
  private ActionLoggerService actionloggerService;


  @RequestMapping(value = "/userProfile", method = RequestMethod.GET)
  public ModelAndView getUserProfilePage(HttpServletRequest request) {
    ModelMap modelMap = new ModelMap();
    Session.setApplicationRefNo("");
//    Session.setApplicationLanguage("en");
    modelMap.put("systemUser", Session.getSystemUser());
    return new ModelAndView("userPrfile", modelMap);
  }


  @RequestMapping(value = "/userProfile", method = RequestMethod.POST)
  public String updateUserProfile(HttpServletRequest request, @ModelAttribute("systemUser") SystemUser systemUser) {
    ModelMap modelMap = new ModelMap();
    systemUser.setActiveStatus(YesNoStatus.NO);
    systemUserService.saveSystemUser(systemUser);
    Session.setApplicationRefNo("");
//    Session.setApplicationLanguage("en");
    modelMap.put("systemUser", systemUser);
    return "redirect:userProfile.htm";
  }


  @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
  public String getChangePasswordPage(HttpServletRequest request) {
    return "changePassword";
  }

  @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
  public String updatePassword(HttpServletRequest request) {
    String oldPassword = request.getParameter("oldPassword");
    String newPassword = request.getParameter("newPasswordOne");
    long systemUserId = Session.getLoggedUserId();
    systemUserService.changeSystemUserPassword(systemUserId, oldPassword, newPassword);
    return "changePassword";
  }


  @RequestMapping(value = "/registerUser", method = RequestMethod.GET)
  public ModelAndView getRegisterUserPage(HttpServletRequest request) {
    ModelMap modelMap = new ModelMap();
    long userId = 0;

    try {
      if (!StringUtils.isBlank(request.getParameter("userId"))) {
        userId = Long.parseLong(request.getParameter("userId").trim());
      }
      if (userId > 0) {
        SystemUser systemuser = systemUserService.findSystemUser(userId);
        for (int i = 0; i < systemuser.getUserRoles().size(); i++) {

          if (systemuser.getUserRoles().get(i).getUserRoleType() != UserRoleType.ROLE_USER
              && systemuser.getUserRoles().get(i).getUserRoleType() != UserRoleType.ROLE_GUEST
              && systemuser.getUserRoles().get(i).getUserRoleType() != UserRoleType.NONE) {
            modelMap.put("systemuserrole", systemuser.getUserRoles().get(i).getUserRoleType());

            // System.out.println(" UserRoleType.ROLE_USER =============== "
            // + systemuser.getUserRoles().get(i).getUserRoleType().toString());
          }
        }
        modelMap.put("systemuser", systemuser);
      }
    } catch (Exception e) {

    }



    modelMap.put("users", systemUserService.findAllSystemUsers());
    modelMap.put("userTypes", UserRoleType.values());
    modelMap.put("districts", districtService.findAllDestrict());
    Session.setApplicationRefNo("");
//    Session.setApplicationLanguage("en");
    return new ModelAndView("registerUser", modelMap);
  }


  @RequestMapping(value = "/findUser", method = RequestMethod.POST)
  public String findRegisteredUser(@RequestParam("forwardUser") long userId, HttpServletRequest request) {
    try {
      if (userId > 0) {
        return "redirect:registerUser.htm?userId=" + userId + "&" + ApplicationConstants.MESSAGE + "="
            + ApplicationConstants.SUCCESS;
      } else {
        return "redirect:registerUser.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
      }
    } catch (Exception e) {
      return "redirect:registerUser.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
    }
  }


  @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
  public String registerUser(HttpServletRequest request, @ModelAttribute("systemUser") SystemUser systemUser,
      BindingResult errors) {
    SystemUser user = null;
    Action action = null;

    if (errors.hasErrors()) {
      System.out.println("------------error occured");
    }

    try {
      if (!StringUtils.isBlank(request.getParameter("userId"))) {
        user = systemUserService.findSystemUser(systemUser.getUserId());
        user.setUpdatedDateTime(new Date());
        user.setUpdatedUser(Session.getLoggedUserId());
        action = Action.USER_UPDATED;
      } else {
        user = new SystemUser();
        user.setCreatedDateTime(new Date());
        user.setCreatedUser(Session.getLoggedUserId());
        action = Action.USER_CREATED;
      }

      user.setUserName(systemUser.getUsername());
      user.setPassword(systemUser.getPassword());
      user.setUserDisplayName(systemUser.getUserDisplayName());

      if (user.getUserRoles() != null) {
        user.getUserRoles().clear();
      }
      List<UserRole> userRoles = new ArrayList<UserRole>();
      if (request.getParameter("userrole").equals(UserRoleType.ROLE_ADMIN.toString())) {
        UserRole userRoleAdmin = new UserRole();
        userRoleAdmin.setUserRoleType(UserRoleType.ROLE_ADMIN);
        userRoleAdmin.setCertifyStatus(true);
        userRoles.add(userRoleAdmin);
      } else if (request.getParameter("userrole").equals(UserRoleType.ROLE_DIVISION_HEAD.toString())) {
        UserRole userRoleAdmin = new UserRole();
        userRoleAdmin.setUserRoleType(UserRoleType.ROLE_DIVISION_HEAD);
        userRoleAdmin.setCertifyStatus(true);
        userRoles.add(userRoleAdmin);
      }
      // } else {
      UserRole userRole = new UserRole();
      userRole.setUserRoleType(UserRoleType.ROLE_USER);
      userRoles.add(userRole);
      // }
      user.setUserRoles(userRoles);

      user.setActiveStatus(systemUser.getActiveStatus());

      user.setEmailAddress(systemUser.getEmailAddress());
      user.setStaffId(systemUser.getStaffId());
      user.setStaffName(systemUser.getStaffName());
      user.setDesignation(systemUser.getDesignation());
    } catch (Exception e) {
      e.printStackTrace();
    }

    SystemUser savedUser = systemUserService.saveSystemUser(user);

    if (savedUser != null) {
      // set action logger
      actionloggerService.setActionLogger(action, "created by" + Session.getLoggedUserId(), savedUser.getUserId(),
          Session.getLoggedUserId());
      return "redirect:registerUser.htm?userId=" + savedUser.getUserId() + "&" + ApplicationConstants.MESSAGE + "="
          + ApplicationConstants.SUCCESS;
    } else {
      return "redirect:registerUser.htm?" + ApplicationConstants.MESSAGE + "=" + ApplicationConstants.ERROR;
    }
  }


  @RequestMapping(value = "/validateUserName", method = RequestMethod.GET)
  public @ResponseBody String getValidateUserName(@RequestParam("username") String username) {
    System.out.println("username###" + username);
    try {
      return systemUserService.validateUsername(username);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  // @RequestMapping(value = "/registerAdmin", method = RequestMethod.GET)
  // public ModelAndView getRegisterAdminPage(HttpServletRequest request) {
  // ModelMap modelMap = new ModelMap();
  // modelMap.put("systemUser", new SystemUser());
  // return new ModelAndView("registerAdmin", modelMap);
  // }
  //
  //
  // @RequestMapping(value = "/registerAdmin", method = RequestMethod.POST)
  // public ModelAndView registerAdmin(HttpServletRequest request, @ModelAttribute("systemUser")
  // SystemUser systemUser) {
  // ModelMap modelMap = new ModelMap();
  // systemUserService.saveSystemUser(systemUser, UserRoleType.ROLE_ADMIN);
  // modelMap.put("systemUser", systemUser);
  // return new ModelAndView("registerAdmin", modelMap);
  // }


  @RequestMapping(value = "/getUserDesignation", method = RequestMethod.GET)
  public @ResponseBody String getUserDesignation(@RequestParam("userId") Long userId) {
    System.out.println("-------------------------------------- " + userId);
    try {
      return systemUserService.findSystemUser(userId).getDesignation().toString();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
