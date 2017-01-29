package com.lk.std.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.lk.std.model.Messages;

public interface MessageRepository extends JpaRepository<Messages, Long> {

	 	@Modifying
	    @Transactional
	    @Query("delete from messages u where u.id = ?1 and u.grade.id=?2")
	    int deleteMessageByMessageIdAndGradeId(long id,long gradeId);
	 	
	 	@Query("select s from messages s where s.grade.id=?1")
	 	List<Messages> findAllMessageInGrade (long gradeId);
}
