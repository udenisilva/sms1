package com.lk.std.service;

import java.util.List;

import com.lk.std.model.Branch;
import com.lk.std.model.Staff;
import com.lk.std.model.Subject;

public interface StaffService {

	public List<Staff> findAll();
	
	public Staff save(Staff stafff);

	public Staff findById(long id);
	
	public int getNextstaff_id();
	
	public List<Staff> findAllByBranch(Branch branch);
	
	public List<Staff> findAllBySubject(Subject subject);
}
