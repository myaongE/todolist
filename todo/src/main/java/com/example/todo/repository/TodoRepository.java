package com.example.todo.repository;

import com.example.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    // id로 Todo 찾는 메서드 정의
    Optional<Todo> findById(Long id);

    // Todo 삭제
    void deleteById(Long id);


    // 중요도와 생성일 순으로 정렬된 모든 Todo 목록 가져오기
    List<Todo> findAllByOrderByImportantDescCreatedAtDesc();
}
