package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.BranchRepository;
import com.lk.std.model.Branch;
import com.lk.std.model.Grade;

@Service
@Transactional
public class BranchServiceImp implements BranchService{

	@Autowired
	BranchRepository branchRepository;
	
	@Override
	public List<Branch> findAll() {		
		return (List<Branch>) branchRepository.findAll();
	}

	@Override
	public Branch save(Branch branch) {		 
		return branchRepository.save(branch);
	}

	@Override
	public Branch findById(Long id) { 
		return branchRepository.findById(id);
	}

	@Override
	public List<Grade> findGradeById(long branchId) { 
		return branchRepository.findGradeById(branchId);
	}

}
