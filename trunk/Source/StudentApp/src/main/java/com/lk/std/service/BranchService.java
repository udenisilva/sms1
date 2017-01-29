package com.lk.std.service;

import java.util.List;

import com.lk.std.model.Branch;
import com.lk.std.model.Grade;

public interface BranchService {

	public List<Branch> findAll();

	public Branch save(Branch branch);
	
	public Branch findById(long id);

	public List<Grade> findGradeById(long branchId);
	
	public int nextBranchId();
	
	public String nextBranchCode();
}
