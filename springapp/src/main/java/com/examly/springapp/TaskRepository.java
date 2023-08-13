package com.examly.springapp;
import org.springframework.data.repository.CrudRepository;
public interface TaskRepository extends CrudRepository<Task, Long> {
    Task findByTaskHolderName(String taskHolderName);
}