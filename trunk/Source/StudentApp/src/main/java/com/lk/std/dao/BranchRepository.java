package com.lk.std.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.Branch;
import com.lk.std.model.Grade;

public interface BranchRepository extends CrudRepository<Branch, Long>{

	public Branch findById(Long id);

	public List<Grade> findGradeById(long branchId);

}
