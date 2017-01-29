package com.lk.std.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lk.std.model.Branch;
import com.lk.std.model.Grade;
import com.lk.std.model.Subject;

public interface SubjectRepository extends CrudRepository<Subject,Long>{

	public List<Subject> findByGrade(Grade gradeId);
	
	@Query("select s from subject s where s.branch.id=?1")
	public List<Subject> findAllSubjectsByBranchId(long branchId);
	
	@Query("select s.code from subject s order by s.id asc")
	public List<String> findANextSubjectsCode();
	
	@Query("select s from subject s where s.branch.id=?1 and s.grade.id=?2")
	public List<Subject> findByBranchAndGrade(long branchId,long gradeId);

}
