package com.hint.processor.todo.app;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todo_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Todo {
    private @Id Long id;
    private String todo;
    private Boolean completed;
    private String userId;

}
