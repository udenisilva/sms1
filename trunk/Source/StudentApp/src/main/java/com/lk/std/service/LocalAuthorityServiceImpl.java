/**
 * 
 */
package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.LocalAuthorityRepository;

import com.lk.std.model.District;
import com.lk.std.model.LocalAuthority;

/**
 * @author dhiripitiy001
 *
 */
@Service
@Transactional
public class LocalAuthorityServiceImpl implements LocalAuthorityService {

  @Autowired
  LocalAuthorityRepository localAuthorityDAO;

  @Override
  public List<LocalAuthority> findLocalAuthorityByDistrict(long districtId) {
    District dis = new District();
    dis.setDistrictId(districtId);
    return localAuthorityDAO.findByDistrict(dis);
  }

  @Override
  public LocalAuthority findLocalAuthority(long localAuthorityId) {
    return localAuthorityDAO.findOne(localAuthorityId);
  }



}
