package com.example.todo.service;

import com.example.todo.entity.Todo;

import java.util.List;

public interface TodoService {

    // 전체 할 일 목록을 가져오는 메서드
    List<Todo> findAll();

    // ID로 특정 할 일을 가져오는 메서드
    Todo findById(Long id);

    // 새로운 할 일을 추가하는 메서드
    Todo save(Todo todo);

    // 할 일을 삭제하는 메서드
    void deleteById(Long id);

    // ID로 할 일을 수정하는 메서드
    Todo updateById(Long id, Todo updatedTodo);
}
