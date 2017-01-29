package com.lk.std.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.Branch;
import com.lk.std.model.Grade;

public interface BranchRepository extends CrudRepository<Branch, Long>{
	//@Modifying
	//@Transactional
	
	public Branch findById(long id);

	public List<Grade> findGradeById(long branchId);
	
	
//	@Query("select id from branch order by id desc limit 1 ")
	@Query("select max(id)+1 from branch ")
	public int getNextbranch_id();
	
	@Query("select code from branch order by id asc")
	public List<String> getNextBranch_code();

}
