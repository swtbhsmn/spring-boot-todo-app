package com.mywebapp.todo.web_app_todo.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int count = 0;
    static {
        todos.add(new Todo(++count, "user123", "Learn spring boot.", LocalDate.now(), false));
        todos.add(new Todo(++count, "user123", "Learn OS.", LocalDate.now().plusDays(30), false));
        todos.add(new Todo(++count, "test@gmail.com", "Learn IOT.", LocalDate.now(), false));
    }

    public List<Todo> getTodoLists() {
        return todos;
    }

    public List<Todo> getTodoListByUsername(String username) {
        return todos.stream().filter(todo -> todo.getUsername().equalsIgnoreCase(username))
                .collect(Collectors.toList());
    }

    public void addTodo(String username, String description, LocalDate targateDate, Boolean done) {
        todos.add(new Todo(++count, username, description, targateDate, done));
    }

    public void deleteTodoItem(int id) {
        todos.removeIf(
                todo -> todo.getId() == id);
    }

    public Todo findTodoItem(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;

    }

    public void updateTodoItem(@Valid Todo todo) {
        deleteTodoItem(todo.getId());
        todos.add(todo);
    }
}
