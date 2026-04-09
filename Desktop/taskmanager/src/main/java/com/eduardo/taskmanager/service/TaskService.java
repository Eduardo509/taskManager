package com.eduardo.taskmanager.service;

import com.eduardo.taskmanager.model.Task;
import com.eduardo.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Integer id){
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    public Task getTaskByTitle(String title){
        Optional<Task> task = taskRepository.findByTitle(title);
        return task.orElse(null);
    }


    public Task updateTask(Integer id, Task newTask){
        Task existingTask = getTaskById(id);

        if (existingTask != null){
            existingTask.setTitle(newTask.getTitle());
            existingTask.setDescription(newTask.getDescription());
            existingTask.setCompleted(newTask.isCompleted());

            return taskRepository.save(existingTask);
        }
        return null;
    }

    public Task deleteTask(Integer id){
        Task task = getTaskById(id);

        if (task != null){
            taskRepository.delete(task);
        }
        return task;

    }


}
