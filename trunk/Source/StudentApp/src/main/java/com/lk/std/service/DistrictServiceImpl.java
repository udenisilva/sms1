/**
 * 
 */
package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.DistrictRepository;

import com.lk.std.model.District;

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {

  @Autowired
  private DistrictRepository districtDAO;

  @Override
  public List<District> findAllDestrict() {
    return (List<District>) districtDAO.findAll();
  }

  @Override
  public District findDistrict(long districtId) {
    return districtDAO.findOne(districtId);
  }


}
