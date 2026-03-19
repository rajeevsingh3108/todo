package com.example.todoapp;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TodoService {

    // Global list
    List<Todo> todos = new ArrayList<>();

    // Constructor (initial data)
    public TodoService() {
        todos.add(new Todo(1, "Learn Spring Boot", false));
        todos.add(new Todo(2, "Complete assignment", false));
        todos.add(new Todo(3, "Practice APIs", true));
        todos.add(new Todo(4, "Read documentation", false));
        todos.add(new Todo(5, "Revise concepts", true));
    }

    // GET all
    public List<Todo> getTodos() {
        return todos;
    }

    // GET by ID
    public Todo getTodoById(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    // POST
    public Todo createTodo(Todo todo) {
        todos.add(todo);
        return todo;
    }

    // PUT
    public Todo updateTodo(int id, Todo updatedTodo) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                todo.setTitle(updatedTodo.getTitle());
                todo.setCompleted(updatedTodo.isCompleted());
                return todo;
            }
        }
        return null;
    }

    // DELETE
    public String deleteTodo(int id) {
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
