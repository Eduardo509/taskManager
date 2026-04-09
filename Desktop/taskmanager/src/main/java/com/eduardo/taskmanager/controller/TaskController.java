package com.eduardo.taskmanager.controller;

import com.eduardo.taskmanager.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TaskController {
    private ArrayList<Task> tasks = new ArrayList<>();

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        tasks.add(task);
        return task;
    }

    @GetMapping("/tasks")
    public ArrayList<Task> showTasks(){
        return tasks;
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable int  id){
        for (Task t: tasks){
            if (t.getId()==id){
                return t;
            }
        }
        return null;
    }
    @GetMapping("/tasks/Title/{title}")
    public Task getTaskByTitle(@PathVariable String title){
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            if (t.getTitle().equals(title)){
                return t;
            }
        }
        return null;
    }

    @PutMapping("/tasks/{id}")
    public Task updateTaskById (@PathVariable int id, @RequestBody Task task){
        Task t = getTaskById(id);
        if (t != null) {
            t.setTitle(task.getTitle());
            t.setDescription(task.getDescription());
            t.setCompleted(task.isCompleted());
        }
        return t;
    }

    @DeleteMapping("/tasks/{id}")
    public Task deleteTaskById(@PathVariable int id){
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            if (t.getId() == id){
                tasks.remove(i);
                return t;
            }
        }
        return null;
    }

}