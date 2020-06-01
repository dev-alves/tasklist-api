package com.tasklist.domain.repository.queries;

import com.tasklist.domain.model.Task;

public interface TaskQueries {

    Task taskExists(Long id);
}
