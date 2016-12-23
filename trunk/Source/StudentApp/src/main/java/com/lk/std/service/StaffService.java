package com.lk.std.service;

import java.util.List;

import com.lk.std.model.Staff;

public interface StaffService {

	public List<Staff> findAll();
	
	public Staff save(Staff stafff);

	public Staff findById(long id);
}
