/**
 * 
 */
package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.DistrictSecretariatRepository;

import com.lk.std.model.District;
import com.lk.std.model.DistrictSecretariat;

@Service
@Transactional
public class DistrictSecretariatServiceImpl implements DistrictSecretariatService {

  @Autowired
  DistrictSecretariatRepository districtSecretariatDAO;

  @Override
  public List<DistrictSecretariat> getDistrictSecretariatByDistrict(long district) {
    District dis = new District();
    dis.setDistrictId(district);
    return districtSecretariatDAO.findByDistrict(dis);

  }

  @Override
  public DistrictSecretariat findDistrictSecretariat(long districtSecId) {
    return districtSecretariatDAO.findOne(districtSecId);
  }

}
