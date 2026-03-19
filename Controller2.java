package com.example.todoapp;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    //Global list (in-memory storage)
    List<Todo> todos = new ArrayList<>();

    
    public TodoController() {
        todos.add(new Todo(1, "Learn Spring Boot", false));
        todos.add(new Todo(2, "Complete assignment", false));
        todos.add(new Todo(3, "Practice APIs", true));
        todos.add(new Todo(4, "Read documentation", false));
        todos.add(new Todo(5, "Revise concepts", true));
    }

    //  GET all todos
    @GetMapping
    public List<Todo> getTodos() {
        return todos;
    }

    // GET todo by id
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    //POST create new todo
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        todos.add(todo);
        return todo;
    }

    // PUT update todo
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo updatedTodo) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                todo.setTitle(updatedTodo.getTitle());
                todo.setCompleted(updatedTodo.isCompleted());
                return todo;
            }
        }
        return null;
    }

    //  DELETE todo
    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable int id) {
        Iterator<Todo> iterator = todos.iterator();

        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
                return "Todo deleted successfully";
            }
        }

        return "Todo not found";
    }
}
