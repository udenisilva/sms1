package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.constant.ApplicationConstants;
import com.lk.std.constant.GeneralEnumConstants.UserRoleType;
import com.lk.std.dao.SystemUserRepository;

import com.lk.std.model.District;
import com.lk.std.model.SystemUser;

@Service
@Transactional
public class SystemUserServiceImpl implements SystemUserService {

  @Autowired
  private SystemUserRepository systemUserRepository;

  @Override
  public SystemUser saveSystemUser(SystemUser systemUser, UserRoleType userRoleType) {
    return systemUserRepository.save(systemUser);
  }

  @Override
  public SystemUser saveSystemUser(SystemUser systemUser) {
    return systemUserRepository.save(systemUser);
  }

  @Override
  public String changeSystemUserPassword(long userId, String oldPassword, String newPassword) {

    SystemUser systemUser = systemUserRepository.findByUserId(userId);
    if (systemUser.getPassword().toLowerCase().equals(oldPassword.toLowerCase())) {
      systemUser.setPassword(newPassword);
      systemUserRepository.save(systemUser);
      System.out.println(ApplicationConstants.SUCCESS);
      return ApplicationConstants.SUCCESS;
    } else {
      return ApplicationConstants.ERROR;
    }
  }

  @Override
  public List<SystemUser> findAllSystemUsers() {
    return (List<SystemUser>) systemUserRepository.findAll();
  }

  @Override
  public SystemUser findSystemUser(long userId) {
    return systemUserRepository.findByUserId(userId);
  }

  @Override
  public String validateUsername(String username) {
    SystemUser user = systemUserRepository.findByUserName(username);
    if (user == null) {
      return ApplicationConstants.SUCCESS;
    } else {
      return ApplicationConstants.ERROR;
    }
  }
 

}