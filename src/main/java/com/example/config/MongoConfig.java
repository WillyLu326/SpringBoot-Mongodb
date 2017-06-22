package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfig {
	
	@Bean
	public MongoTemplate mongoTemplate() {
		MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient("127.0.0.1"), "Omega");
		return mongoTemplate;
	}
}
