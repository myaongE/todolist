package com.example.todo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // todos 리스트를 가져오는 메소드
    @GetMapping
    public String getAllTodos(Model model) {
        List<Todo> todos = todoService.findAll();
        
        if (todos == null) {
            todos = List.of();  // todos가 null이면 빈 리스트로 설정
        }
        
        model.addAttribute("todos", todos);  // 뷰로 todos 리스트를 전달
        model.addAttribute("todo", new Todo());  // 새 Todo 객체를 빈 객체로 전달
        return "todo-list";  // 뷰 이름
    }

    // 새 Todo를 추가하는 메소드
    @PostMapping
    public String createTodo(@ModelAttribute Todo todo) {
        todoService.save(todo);  // Todo 저장
        return "redirect:/todos";  // 새 Todo를 저장하고 목록 페이지로 리다이렉트
    }

    @GetMapping("/{id}/edit")
    public String editTodo(@PathVariable("id") Long id, Model model) {
        Todo todo = todoService.findById(id);  // id로 Todo를 찾기
        model.addAttribute("todo", todo);  // 수정할 Todo 객체 전달
        return "todo-edit";  // 수정 페이지로 이동
    }

    // 일정 수정
    @PostMapping("/{id}/edit")
    public String updateTodo(@PathVariable("id") Long id, @ModelAttribute Todo todo) {
        todoService.updateById(id, todo);  // id를 기준으로 Todo 수정
        return "redirect:/todos";  // 수정 후 목록 페이지로 리다이렉트
    }

    // 일정 삭제 
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodoById(@PathVariable("id") Long id) {
        try {
            todoService.deleteById(id);  // id로 Todo를 삭제
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Todo not found with id: " + id);  // 실패한 경우
        }
    }





}
