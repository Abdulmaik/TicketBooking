package com.abed.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	

	@GetMapping("/admin/adminTest")
	public String adminTest ()
	{
		
		return "adminPage"; 
	}
}
