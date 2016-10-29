package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.UtilityLineTypesRepository;

import com.lk.std.model.UtilityLineTypes;

@Service
@Transactional
public class UtilityLineTypesServiceImpl implements UtilityLineTypesService {
  @Autowired
  private UtilityLineTypesRepository utilityLineTypesdao;

  @Override
  public List<UtilityLineTypes> getAllUtilityLines() {
    return (List<UtilityLineTypes>) utilityLineTypesdao.findAll();
  }

}