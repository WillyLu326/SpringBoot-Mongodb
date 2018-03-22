package com.mongodb.springbootmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
	
	public Student getStudentById(String id) {
		Query query = new Query();
		Criteria criteria = Criteria.where("id").is(id);
		query.addCriteria(criteria);
		return mongoOperations.findById(id, Student.class);
	}
	
}
