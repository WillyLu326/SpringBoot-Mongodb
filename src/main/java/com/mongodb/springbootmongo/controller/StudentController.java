package com.mongodb.springbootmongo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

	@GetMapping(path="/")
	public String home() {
		return "Student Home Page";
	}
}
