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
	public Branch findById(long id) { 
		return branchRepository.findById(id);
	}

	@Override
	public List<Grade> findGradeById(long branchId) { 
		return branchRepository.findGradeById(branchId);
	}

	@Override
	public int nextBranchId() {
		
		int id=0;
		
		try{
			
			id=branchRepository.getNextbranch_id();
			
		}catch (Exception e) {
			id=1;
		}
		return id;
	}

	@Override
	public String nextBranchCode() {
		String newCode="";
		
		try{
		List<String> codeList=(List<String>) branchRepository.getNextBranch_code();
		String code="";
		for (String string : codeList) {
			code=string;
		}
		
		String ss[]=code.split("-");
		String id=ss[1];
		int nextId=Integer.parseInt(id)+1;
		
		 newCode="B-"+nextId;
		}catch(Exception exx){
			exx.printStackTrace();
			 newCode="B-1";		
		}
		
		
		return newCode;
	}

}
