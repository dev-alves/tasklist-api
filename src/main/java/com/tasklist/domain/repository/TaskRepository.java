package com.tasklist.domain.repository;

import com.tasklist.domain.model.Task;
import com.tasklist.domain.repository.queries.TaskQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends
        JpaRepository<Task, Long>,
        JpaSpecificationExecutor<Task>,
        TaskQueries {

}
