package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.StaffRepository;
import com.lk.std.model.Branch;
import com.lk.std.model.Staff;
import com.lk.std.model.Subject;

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

	@Override
	public Staff findById(long id) {		
		return staffRepository.findById(id);
	}

	@Override
	public int getNextstaff_id() {
		
		int maxId=0;
		
		try{
			maxId=staffRepository.getNextstaff_id();
			
		}catch (Exception e) {
			maxId=1;
		}
		
		return maxId;
	}

	@Override
	public List<Staff> findAllByBranch(Branch branch) {
		System.out.println("CAME findAllByBranch");
		return staffRepository.findAllByBranch(branch);
	}

	@Override
	public List<Staff> findAllBySubject(Subject subject) {
		System.out.println("CAME findAllBySubject");
		return null;
	}
}
