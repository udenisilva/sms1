package com.lk.std.dao;

import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.Staff;

public interface StaffRepository extends CrudRepository<Staff,Long>{

	public Staff findById(long id);

}
