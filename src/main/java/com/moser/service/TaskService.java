package com.moser.service;

import com.moser.model.Task;
import com.moser.repository.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Juliano Moser
 */
@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Task save(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(String taskId) {
        return repository.findById(taskId).get();
    }

    public List<Task> findBySeverity(int severity) {
        return repository.findBySeverity(severity);
    }

    public List<Task> findByAssignee(String assignee) {
        return repository.findByAssignee(assignee);
    }

    public Task update(Task taskRequest) {
        Task existingTask = repository.findById(taskRequest.getTaskId()).get();
        BeanUtils.copyProperties(taskRequest, existingTask);
        return repository.save(existingTask);
    }

    public String delete(String taskId) {
        repository.deleteById(taskId);
        return taskId + " task delete from dashboard";
    }
}
