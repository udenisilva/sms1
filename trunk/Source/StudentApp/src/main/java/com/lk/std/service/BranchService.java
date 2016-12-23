package com.lk.std.service;

import java.util.List;

import com.lk.std.model.Branch;

public interface BranchService {

	public List<Branch> findAll();

	public Branch save(Branch branch);
	
	public Branch findById(Long id);
}
