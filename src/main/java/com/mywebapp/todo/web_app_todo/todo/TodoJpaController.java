package com.mywebapp.todo.web_app_todo.todo;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("username")
public class TodoJpaController {

    private TodoRepository todoRepository;

    public TodoJpaController(TodoRepository todoRepository) {
        super();
        this.todoRepository = todoRepository;
    }

    @RequestMapping(value = "lists", method = RequestMethod.GET)
    @ResponseBody
    public List<Todo> requestAllTodo() {
        List<Todo> data = todoRepository.findAll();
        return data;
    }

    @RequestMapping(value = "todo-list", method = RequestMethod.GET)
    public String requestMethodName(ModelMap model) {
        List<Todo> data = todoRepository.findByUsername(getLoggedInUsername());
        model.addAttribute("todos", data);
        return "todoList";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        model.addAttribute("todo", new Todo());
        return "addTodo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "addTodo";
        }
        todo.setUsername(getLoggedInUsername());
        todoRepository.save(todo);
        return "redirect:todo-list";
    }

    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:todo-list";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showPageUpdateTodo(@RequestParam int id, ModelMap model) {
        model.addAttribute("todo", todoRepository.findById(id).get());
        return "updateTodo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "addTodo";
        }
        todo.setUsername(getLoggedInUsername());
        todoRepository.save(todo);
        return "redirect:todo-list";
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}