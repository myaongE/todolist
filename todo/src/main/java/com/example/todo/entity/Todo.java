package com.example.todo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    private Timestamp createdAt;

    private String tag; // 태그 필드

    private boolean important = false; // 중요 여부 (기본값: false)

    public enum Status {
        PENDING,
        COMPLETED
    }
}
