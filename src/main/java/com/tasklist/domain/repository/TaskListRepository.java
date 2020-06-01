package com.tasklist.domain.repository;

import com.tasklist.domain.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskListRepository
        extends JpaRepository<TaskList, Long>  {

}
