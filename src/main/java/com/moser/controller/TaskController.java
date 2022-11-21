package com.moser.controller;

import com.moser.model.Task;
import com.moser.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Juliano Moser
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task save(@RequestBody Task task) {
        return taskService.save(task);
    }

    @GetMapping
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/{taskId}")
    public Task findById(@PathVariable String taskId) {
        return taskService.findById(taskId);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> findBySeverity(@PathVariable int severity) {
        return taskService.findBySeverity(severity);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> findBySeverity(@PathVariable String assignee) {
        return taskService.findByAssignee(assignee);
    }

    @PutMapping
    public Task update(@RequestBody Task task) {
        return taskService.update(task);
    }

    @DeleteMapping("/{taskId}")
    public String delete(@PathVariable String taskId) {
        return taskService.delete(taskId);
    }
}
