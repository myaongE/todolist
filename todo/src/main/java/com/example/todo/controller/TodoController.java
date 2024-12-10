package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class TodoController {

	 @GetMapping("/main")
	    public String domain(Model model) {
	        return "main"; // main.html로 매핑
	    }
	
}
