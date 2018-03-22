package com.mongodb.springbootmongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.springbootmongo.model.Student;
import com.mongodb.springbootmongo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping(path="/")
	public String getStudents() {
		return "Student Home Page";
	}
	
	@PostMapping(path="/")
	public void saveStudent(@RequestBody Student student) {
		System.out.println(student.toString());
	}
}
