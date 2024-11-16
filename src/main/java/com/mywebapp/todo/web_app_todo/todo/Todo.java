package com.mywebapp.todo.web_app_todo.todo;

import java.time.LocalDate;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private int id;
    private String username;
    @Size(min = 5, message = "Description must be at least 5 characters long")
    private String description;
    private LocalDate targetDate;
    private boolean done;
}
