package com.tasklist.api;

import com.tasklist.api.vo.StatusTaskVO;
import com.tasklist.domain.model.StatusTask;
import com.tasklist.domain.model.Task;
import com.tasklist.domain.repository.TaskRepository;
import com.tasklist.domain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository tasks;

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task salvar(@RequestBody @Validated Task task, Errors errors) {
        return taskService.salvar(task);
    }

    @GetMapping
    public List<Task> listar() {
        return tasks.findAll();
    }

    @PutMapping("/{taskId}")
    public Task atualizar(@PathVariable Long taskId, @RequestBody @Validated Task task) {
        return taskService.atualizar(taskId, task);
    }

    @PutMapping("/remover")
    public void remover(@PathVariable Long taskId) {
        taskService.deletar(taskId);
    }

    @PutMapping("/status/{taskId}")
    public Task atualizarStatus(@PathVariable Long taskId, @RequestBody StatusTaskVO task) {
        return taskService.atualizarStatus(taskId, task.getStatusTask());
    }

    @DeleteMapping("/{taskId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long taskId) {
        taskService.deletar(taskId);
    }
}
