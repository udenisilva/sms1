/**
 * 
 */
package com.lk.std.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.DistrictSecretariat;
import com.lk.std.model.GramaNiladhariDivision;

public interface GramaNiladhariDivisionRepository extends CrudRepository<GramaNiladhariDivision, Long> {

  public List<GramaNiladhariDivision> findByDistrictSecId(DistrictSecretariat districtSecId);
}
