/**
 * 
 */
package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.GramaNiladhariDivisionRepository;

import com.lk.std.model.DistrictSecretariat;
import com.lk.std.model.GramaNiladhariDivision;

@Service
@Transactional
public class GramaNiladhariDivisionServiceImpl implements GramaNiladhariDivisionService {

  @Autowired
  GramaNiladhariDivisionRepository gramaNiladhariDivisionDAO;

  @Override
  public List<GramaNiladhariDivision> findGNDivisionNoByDistrictSecretariat(long districtSecId) {
    DistrictSecretariat disSec = new DistrictSecretariat();
    disSec.setDistrictSecId(districtSecId);
    return gramaNiladhariDivisionDAO.findByDistrictSecId(disSec);
  }

  @Override
  public GramaNiladhariDivision findGramaNiladhariDivision(long gramaNiladhariDivisionId) {
    return gramaNiladhariDivisionDAO.findOne(gramaNiladhariDivisionId);
  }

}