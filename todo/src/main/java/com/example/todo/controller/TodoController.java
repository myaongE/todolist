package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class TodoController {

	 @GetMapping("/main")
	    public String domain(Model model) {
	        model.addAttribute("todayTime", "7h 15min");
	        model.addAttribute("task1", "Take kids to school");
	        model.addAttribute("task1Time", "8:00-8:30AM");
	        model.addAttribute("task2", "Process email");
	        model.addAttribute("task2Time", "8:00-9:30AM");
	        model.addAttribute("task3", "Daily Stand-Up meeting");
	        model.addAttribute("task3Time", "9:00-10:00AM");
	        model.addAttribute("tomorrowTime", "6h 30min");
	        model.addAttribute("task4", "Breakfast with the Marketing team");
	        model.addAttribute("task4Time", "8:00-8:30AM");
	        return "main"; // main.html로 매핑
	    }
	
}
