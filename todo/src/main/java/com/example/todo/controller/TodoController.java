package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateStatus(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        Todo todo = todoService.updateStatus(id, updatedTodo.getStatus());
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/api/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build(); // 성공적으로 삭제되었으면 204 No Content 응답
    }

}