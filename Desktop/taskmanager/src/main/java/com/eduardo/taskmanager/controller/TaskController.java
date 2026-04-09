package com.eduardo.taskmanager.controller;

import com.eduardo.taskmanager.model.Task;
import com.eduardo.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskservice){
        this.taskService = taskservice;
    }
    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> showTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable int  id){
        return taskService.getTaskById(id);
    }
    @GetMapping("/tasks/Title/{title}")
    public Task getTaskByTitle(@PathVariable String title) {
        return taskService.getTaskByTitle(title);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTaskById (@PathVariable int id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/tasks/{id}")
    public Task deleteTaskById(@PathVariable int id){
        return taskService.deleteTask(id);
    }

}