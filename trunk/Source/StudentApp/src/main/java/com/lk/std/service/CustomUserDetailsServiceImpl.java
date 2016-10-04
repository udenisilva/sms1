package com.lk.std.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lk.std.dao.SystemUserRepository;

import com.lk.std.model.SystemUser;

@Service("userDetailsService")
@Transactional
public class CustomUserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private SystemUserRepository systemUserDAO;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    System.out.println("CAME HERE CustomUserDetailsServiceImpl");
    try {
      System.out.println("CAME HERE CustomUserDetailsServiceImpl");
      SystemUser systemUser = systemUserDAO.findByUserName(userName);
      System.out.println("systemUser :l " + systemUser);
      return systemUser;
    } catch (Exception e) {
      e.printStackTrace(System.out);
      throw new UsernameNotFoundException(userName);
    }
  }

}
