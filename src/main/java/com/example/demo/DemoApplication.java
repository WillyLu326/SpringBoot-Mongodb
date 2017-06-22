package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.domain.User;

@SpringBootApplication
@ComponentScan(basePackages={"com.example.controller"})
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		
		MongoTemplate mongoTemplate = (MongoTemplate) ctx.getBean("mongoTemplate");
		
		List<User> users = new ArrayList<>();
		
		User user1 = new User("Name", 11);
		User user2 = new User("Hello", 22);
		
		users.add(user1);
		users.add(user2);
		
		mongoTemplate.insert(users, User.class);
		System.out.println("========================");
		
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("Hello").and("age").is(22));
		
		User userTest = mongoTemplate.findOne(query, User.class);
		System.out.println("UserTest " + userTest.toString());
	}
}
