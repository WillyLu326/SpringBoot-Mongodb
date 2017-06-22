package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnotherController {

	@RequestMapping("/another")
	public String another() {
		return "another controller";
	}
	
}
