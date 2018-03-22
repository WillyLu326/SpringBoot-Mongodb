package com.mongodb.springbootmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.mongodb.springbootmongo.model.Student;

@Service
public class StudentService {

	@Autowired
	private MongoOperations mongoOperations;
	
	public void createStudent() {
		Student student = new Student();
		student.setName("Willy Lu");
		student.setSchool("CPP");
		
		this.mongoOperations.save(student);
	}
	
}
