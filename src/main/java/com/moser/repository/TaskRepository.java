package com.moser.repository;

import com.moser.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author Juliano Moser
 */
public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findBySeverity(int severity);

    @Query("{assignee:  ?0}")
    List<Task> findByAssignee(String assignee);
}
