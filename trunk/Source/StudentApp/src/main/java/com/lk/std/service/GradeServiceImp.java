package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.GradeRepository;
import com.lk.std.model.Branch;
import com.lk.std.model.Grade;
import com.lk.std.model.Student;

@Service
@Transactional
public class GradeServiceImp implements GradeService{

	@Autowired
	GradeRepository gradeRepository;
	
	@Override
	public List<Grade> findAll() {		
		return (List<Grade>) gradeRepository.findAll();
	}

	@Override
	public Grade save(Grade grade) {		 
		return gradeRepository.save(grade);
	}

	@Override
	public Grade findById(long gradeId) {		
		return gradeRepository.findById(gradeId);
	}

	@Override
	public List<Student> findStudentById(long gradeID) {		
		return gradeRepository.findStudentById(gradeID) ;
	}

	@Override
	public List<Grade> findByBranch(Branch branch) { 
		return gradeRepository.findByBranch(branch);
	}

	@Override
	public int remove(Grade grade) {
		int result=0;
		try{
		 gradeRepository.delete(grade);
		 result=1;
		}catch (Exception e) {
			result=0;
		}
		
		return result;
	}

	@Override
	public int findByGradeAndId(String grade, long gradeId) {
			int exists=0;
	
			try{
			Grade g=gradeRepository.findByGradeAndId(grade, gradeId);
				if(g!=null){
					exists=1;
					System.out.println("HEREEEEEEEEE 111111111111 ");
				}else{
					exists=0;
					System.out.println("HEREEEEEEEEE 2222222222222222222222 ");
				}
			}catch (Exception e) {
				System.out.println("ERRRORRRRRRRRRRRRRRRRR ");
				e.printStackTrace();
				exists=0;
			}
		
		return exists;
	}

}
