package com.tasklist.domain.service;

import com.tasklist.domain.model.StatusTask;
import com.tasklist.domain.model.Task;
import com.tasklist.domain.repository.TaskListRepository;
import com.tasklist.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskListRepository taskListRepository;

    public Task salvar(Task task) {
        return taskRepository.save(task);
    }

    public void deletar(Long id) {
        Task task = taskRepository.taskExists(id);
        taskRepository.delete(task);
    }

    public Task atualizar(Long taskId, Task task) {
        taskRepository.taskExists(taskId);
        task.setDataEdicao(LocalDate.now());
        return salvar(task);
    }

    public Task atualizarStatus(Long taskId, int status) {
        Task task = taskRepository.taskExists(taskId);
        StatusTask statusTask = StatusTask.values()[status];
        task.setStatus(statusTask);

        if(statusTask == StatusTask.FINALIZADO) {
            task.setDataFinal(LocalDate.now());
        }

        return atualizar(taskId, task);
    }
}
