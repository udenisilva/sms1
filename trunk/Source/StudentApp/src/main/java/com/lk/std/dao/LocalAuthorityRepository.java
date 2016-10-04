/**
 * 
 */
package com.lk.std.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.District;
import com.lk.std.model.LocalAuthority;

public interface LocalAuthorityRepository extends CrudRepository<LocalAuthority, Long> {

  public List<LocalAuthority> findByDistrict(District district);


}
