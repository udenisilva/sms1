package com.lk.std.service;

import java.util.List;

import com.lk.std.constant.GeneralEnumConstants.UserRoleType;

import com.lk.std.model.District;
import com.lk.std.model.SystemUser;

public interface SystemUserService {

  public List<SystemUser> findAllSystemUsers();

  public SystemUser findSystemUser(long userId);

  public SystemUser saveSystemUser(SystemUser systemUser);

  public SystemUser saveSystemUser(SystemUser systemUser, UserRoleType userRoleType);

  public String changeSystemUserPassword(long userId, String oldPassword, String newPassword);

  public String validateUsername(String username);
 
}
