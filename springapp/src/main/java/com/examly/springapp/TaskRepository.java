package com.examly.springapp;
import com.examly.springapp.*;
import org.springframework.data.repository.CrudRepository;
public interface TaskRepository extends CrudRepository<Task, Long> {
    Task findByTaskHolderName(String taskHolderName);
    Task findById(int id);
    Task orElse();
    Task deleteById(int id);
}