/**
 * 
 */
package com.lk.std.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.District;
import com.lk.std.model.DistrictSecretariat;

public interface DistrictSecretariatRepository extends CrudRepository<DistrictSecretariat, Long> {

  public List<DistrictSecretariat> findByDistrict(District district);

}
