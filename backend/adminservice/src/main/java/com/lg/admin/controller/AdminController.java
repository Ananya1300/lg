package com.lg.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
		
	@GetMapping("/welcome")
	public String isWorking() {
		return "Working";
	}
}
