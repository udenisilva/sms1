package com.lk.std.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.District;
import com.lk.std.model.SystemUser;

public interface SystemUserRepository extends CrudRepository<SystemUser, Long> {

  public SystemUser findByUserName(String userName);

  public SystemUser findByUserId(long userId);
  


  
}
