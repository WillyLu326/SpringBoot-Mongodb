package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.domain.User;
import com.mongodb.WriteResult;

@SpringBootApplication
@ComponentScan(basePackages={"com.example.controller"})
public class DemoApplication {

	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		
		MongoTemplate mongoTemplate = (MongoTemplate) ctx.getBean("mongoTemplate");
		
		List<User> users = new ArrayList<>();
		
		User user1 = new User("Willy", 27);
		User user2 = new User("Zheng", 28);
		
		users.add(user1);
		users.add(user2);
		
		// Save
		mongoTemplate.insert(users, User.class);
		System.out.println("========================");
		
		// Find One
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("Willy").and("age").is(27));
		
		User userTest = mongoTemplate.findOne(query, User.class);
		System.out.println("UserTest " + userTest.toString());
		
		// Find All
		query = new Query();
		query.addCriteria(Criteria.where("name").is("Willy").and("age").is(27));
		List<User> queryUsers = mongoTemplate.find(query, User.class);
		for (User user : queryUsers) {
			System.out.println("User find ==> " + user);
		}
		
		// Delete
		mongoTemplate.remove(query, User.class);
		List<User> allUsers = mongoTemplate.findAll(User.class);
		for (User user : allUsers) {
			System.out.println("All Users ==> " + user);
		}
		
	}
}
