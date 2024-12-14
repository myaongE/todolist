package com.example.todo.service;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    // 전체 할 일 목록을 중요도 내림차순, 생성일 내림차순으로 가져오는 메서드
    @Override
    public List<Todo> findAll() {
        return todoRepository.findAllByOrderByImportantDescCreatedAtDesc();
    }

    // ID로 특정 할 일을 가져오는 메서드
    @Override
    public Todo findById(Long id) {
        // Optional<Todo>를 직접 반환하지 않고, Optional에서 실제 Todo 객체를 꺼냄
        return todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Todo not found with id: " + id));
    }

    // 새로운 할 일을 추가하는 메서드
    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }
    // 할 일을 삭제하는 메서드
    @Override
    public void deleteById(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Todo not found with id: " + id));
        todoRepository.delete(todo);
    }

    // ID로 할 일을 수정하는 메서드
    @Override
    public Todo updateById(Long id, Todo updatedTodo) {
        Todo existingTodo = findById(id); // findById로 Todo를 가져옴

        // 기존 Todo를 업데이트
        existingTodo.setTitle(updatedTodo.getTitle());
        existingTodo.setDescription(updatedTodo.getDescription());
        existingTodo.setImportant(updatedTodo.isImportant());
        existingTodo.setStatus(updatedTodo.getStatus());

        return todoRepository.save(existingTodo); // 업데이트된 Todo 저장
    }
}
