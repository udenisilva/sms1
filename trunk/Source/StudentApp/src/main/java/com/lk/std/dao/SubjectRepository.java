package com.lk.std.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.Grade;
import com.lk.std.model.Subject;

public interface SubjectRepository extends CrudRepository<Subject,Long>{

	public List<Subject> findByGrade(Grade gradeId);

}
