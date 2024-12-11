package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public String showTodoList(Model model) {
        model.addAttribute("todo", new Todo()); // 빈 엔티티 객체 전달
        model.addAttribute("todos", todoService.getAllTodos()); // 기존 할 일 목록 전달
        return "todo-list"; // 템플릿 이름
    }

    @PostMapping
    public String addTodo(@ModelAttribute Todo todo) {
        todoService.addTodo(todo); // 새로운 할 일 추가
        return "redirect:/todos";
    }

    @PostMapping("/{id}/status")
    public String updateTodoStatus(@PathVariable Long id, @RequestParam("status") Todo.Status status) {
        todoService.updateTodoStatus(id, status);
        return "redirect:/todos";
    }

    @PostMapping("/{id}/delete")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return "redirect:/todos";
    }
}