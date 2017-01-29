package com.lk.std.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.dao.StudentRepository;
import com.lk.std.model.Grade;
import com.lk.std.model.Student;

@Service
@Transactional
public class StudentServiceImp implements StudentService{

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student save(Student student) {		 
		
		 return studentRepository.save(student); 
	}

	@Override
	public Student findById(long stdId) { 
		return studentRepository.findById(stdId);
	}

	@Override
	public List<Student> findByGrade(Grade grade) { 
		return studentRepository.findByGrade(grade);
	}

	@Override
	public String getLastStudentDetails() {
		
		String newStudent="";
		
		try{
		//Student student=studentRepository.getLastStudentDetails();
			String lastCode="";
			List<String> codeList=studentRepository.getLastStudentDetails();
			for (String string : codeList) {
				lastCode=string;
			}
			
	
		System.out.println("================= 1111111 "+lastCode);
		String ss[]=lastCode.split("-");
		
		int nextId=Integer.parseInt(ss[1])+1;
		String newCode="STU-"+nextId;
		
		System.out.println("================= 222222 "+newCode);
		newStudent=newCode;
		
		}catch(Exception ex){
			System.out.println("================= eeeeeeeeeee ");
			ex.printStackTrace();
			newStudent="STU-1";
		}
		
		return newStudent;
		
	}

	@Override
	public int getNextStudent_id() {
int id=0;
		
		try{
			
			id=studentRepository.getNextStudent_id();
			
		}catch (Exception e) {
			id=1;
		}
		return id;
	}

	@Override
	public List<Student> findAll() {
		return (List<Student>) studentRepository.findAll();
	}
	
 
}
