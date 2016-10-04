package com.lk.std.dao;

import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.District;
import com.lk.std.model.SequenceNumber;

public interface SequenceNumberRepository extends CrudRepository<SequenceNumber, Long>{

	public SequenceNumber findByDistrict(District id);
	
}
