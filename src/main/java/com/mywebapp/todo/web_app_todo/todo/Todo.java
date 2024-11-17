package com.mywebapp.todo.web_app_todo.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @SequenceGenerator(name = "todo_seq", sequenceName = "todo_sequence", initialValue = 105, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_seq")
    private int id;
    private String username;
    @Size(min = 5, message = "Description must be at least 5 characters long")
    private String description;
    private LocalDate targetDate;
    private boolean done;
}
