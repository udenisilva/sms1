package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.DesignationRepository;
import com.lk.std.model.Designation;

@Service
@Transactional
public class DesignationServiceImpl implements DesignationService{

	@Autowired
	DesignationRepository designationRepository;

	@Override
	public List<Designation> findAll() {
		return (List<Designation>) designationRepository.findAll();
	}
}
