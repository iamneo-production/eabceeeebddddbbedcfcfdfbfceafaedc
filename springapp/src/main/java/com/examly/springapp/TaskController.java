package com.examly.springapp;

import com.examly.springapp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @GetMapping("/changeStatus")
    public Task changeStatus(@RequestParam Long id, @RequestParam String newStatus) {
        return taskService.changeTaskStatus(id, newStatus);
    }

    @GetMapping("/deleteTask")
    public void deleteTask(@RequestParam Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/alltasks")
    public Iterable<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/getTask")
    public Task getTaskById(@RequestParam Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/getTaskByHolderName")
    public Task getTaskByHolderName(@RequestParam String taskHolderName) {
        return taskService.getTaskByTaskHolderName(taskHolderName);
    }
}
