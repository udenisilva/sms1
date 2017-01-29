package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.SubjectRepository;
import com.lk.std.model.Branch;
import com.lk.std.model.Grade;
import com.lk.std.model.Subject;

@Service
@Transactional
public class SubjectServiceImp implements SubjectService {

	@Autowired
	SubjectRepository subjectRepository;
	
	@Override
	public List<Subject> findAll() {		 
		return (List<Subject>) subjectRepository.findAll();
	}

	@Override
	public List<Subject> findByGrade(Grade gradeId) {
		return subjectRepository.findByGrade(gradeId);
	}
	

	@Override
	public Subject saveSubjectDetails(Subject subject) {
		return subjectRepository.save(subject);
	}

	@Override
	public List<Subject> getSubjectDetails(int code) {
		return null;
	}

	@Override
	public Subject findById(long id) {
		return subjectRepository.findOne(id);
	}

	@Override
	public List<Subject> findAllSubjectsByBranchId(long branchId) {
		
		List<Subject> sLi=subjectRepository.findAllSubjectsByBranchId(branchId);
		return sLi;
	}

	@Override
	public String generateNextSubjectCode() {
	
		String nextCode="";
		String LastCode="";
		
		try{
		List<String> sLi=subjectRepository.findANextSubjectsCode();
		for (String string : sLi) {
			LastCode=string;
		}
		
		
		String ss[]=LastCode.split("-");
		
		System.out.println("GENERATYEEE "+ss[1]);
		
		int lastCode=Integer.parseInt(ss[1]);
		
		nextCode="SUB-"+(lastCode+1);
		
		System.out.println("GENERATYEEE "+nextCode);
		
		}catch (Exception e) {
			nextCode="SUB-10001";
		}
				
		return nextCode;
		
	}

	@Override
	public List<Subject> findByBranchIdAndGradeId(long branchId,long gradeId) {
		System.out.println("CAME findByBranchIdAndGradeId");
		return subjectRepository.findByBranchAndGrade(branchId, gradeId);
		//return null;
	}

}
