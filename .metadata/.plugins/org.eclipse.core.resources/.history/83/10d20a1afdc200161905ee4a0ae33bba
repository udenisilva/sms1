package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.StaffRepository;
import com.lk.std.model.Staff;

@Service
@Transactional
public class StaffServiceImp implements StaffService{

	@Autowired
	StaffRepository staffRepository;

	@Override
	public List<Staff> findAll() {		 
		return (List<Staff>) staffRepository.findAll();
	}

	@Override
	public Staff save(Staff stafff) {		 
		return staffRepository.save(stafff);
	}
}
