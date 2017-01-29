package com.lk.std.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.Branch;
import com.lk.std.model.Staff;
import com.lk.std.model.Subject;

public interface StaffRepository extends CrudRepository<Staff,Long>{

	public Staff findById(long id);
	
	@Query("select max(id)+1 from staff ")
	public int getNextstaff_id();
	
	public List<Staff> findAllByBranch(Branch branch);
	

	//public List<Staff> findAllBySubject(Subject subject);

}
