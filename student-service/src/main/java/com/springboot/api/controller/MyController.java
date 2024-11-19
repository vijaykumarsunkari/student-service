package com.springboot.api.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.api.entity.Students;
import com.springboot.api.services.StudentsService;
import java.util.List;


@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class MyController {
	
	@Autowired
	private StudentsService studentserve;
	
	@GetMapping("/home")
	public String home() {
	return "Hello";
	}
	
	@GetMapping("/students")
	public List<Students> getStudents(@RequestParam(defaultValue="0") int offset,@RequestParam(defaultValue="10") int limit){
		
		
		return this.studentserve.getStudents(offset,limit);
	}
	
	@PostMapping("/students")
	public Students newStudent(@RequestBody Students student) {
		this.studentserve.newStudent(student);
		return student;
	
	}
	
	@PutMapping("/students/{id}")
	public Students updateStudent(@PathVariable String id,@RequestBody Students student) {
	student.setId(Long.parseLong(id));
	this.studentserve.updateStudents(student);
	return student;
	
	}
	
	@DeleteMapping("/students/{id}")
		public String deleteStudent(@PathVariable String id) {
		this.studentserve.deleteStudent(Long.parseLong(id));
			return "Deleted";
	}

}
