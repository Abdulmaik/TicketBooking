package com.abed.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomLogin {


@GetMapping("/login")
public String logIn()
{
	
return "login"; 	
}
}
