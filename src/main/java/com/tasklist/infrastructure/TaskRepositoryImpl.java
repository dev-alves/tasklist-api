package com.tasklist.infrastructure;

import com.tasklist.domain.exception.TaskNaoEncontradaException;
import com.tasklist.domain.exception.message.TaskMessage;
import com.tasklist.domain.model.Task;
import com.tasklist.domain.repository.TaskRepository;
import com.tasklist.domain.repository.queries.TaskQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepositoryImpl implements TaskQueries {

    @Autowired @Lazy
    private TaskRepository taskRepository;

    @Override
    public Task taskExists(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNaoEncontradaException(String.format(TaskMessage.TASK_NAO_ENCONTRADA, id)));
    }
}
