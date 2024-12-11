package com.example.todo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateStatus(Long id, Todo.Status status) {
        Todo todo = todoRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Todo not found"));
        todo.setStatus(status);
        return todoRepository.save(todo);
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

    @Transactional
    public void delete(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Todo ID: " + id));
        todoRepository.delete(todo);
    }

}
