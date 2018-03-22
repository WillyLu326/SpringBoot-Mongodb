package com.mongodb.springbootmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Student> getStudents() {
		return this.studentService.getStudents();
	}
	
	@PostMapping(path="/")
	public Student saveStudent(@RequestBody Student student) {
		this.studentService.saveStudent(student);
		return student;
	}
	
	@GetMapping(path="/{id}")
	public Student getStudent(@PathVariable String id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping(path="/names/{name}")
	public List<Student> getStudentsByName(@PathVariable String name) {
		return studentService.getStudentsByName(name);
	}
}
