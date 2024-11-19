package com.springboot.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.api.entity.Students;

@Service
public interface StudentsService {
	
	public List<Students> getStudents(int offset,int limit);
	public void newStudent(Students student);
	public void updateStudents(Students student);
	public void deleteStudent(long id);
	
	
}
