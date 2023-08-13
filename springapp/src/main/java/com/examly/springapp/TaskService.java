package com.examly.springapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task changeTaskStatus(Long id, String newStatus) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setTaskStatus(newStatus);
            return taskRepository.save(task);
        }
        return null;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task getTaskByTaskHolderName(String taskHolderName) {
        // Implementation of this method depends on the exact requirements
        // You can create a custom query in the repository or use Spring Data's automatic query generation
        return taskRepository.findByTaskHolderName(taskHolderName);
    }
}
