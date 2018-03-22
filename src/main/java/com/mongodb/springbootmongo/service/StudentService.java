package com.mongodb.springbootmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.mongodb.springbootmongo.model.Student;

@Service
public class StudentService {

	@Autowired
	private MongoOperations mongoOperations;
	
	
	public void saveStudent(Student student) {		
		this.mongoOperations.save(student);
	}
	
	public List<Student> getStudents() {
		return this.mongoOperations.findAll(Student.class);
	}
	
	
	
}
