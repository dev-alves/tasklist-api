package com.tasklist.domain.repository.espec;

import com.tasklist.domain.model.StatusTask;
import com.tasklist.domain.model.Task;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecs {

    public static Specification<Task> naoForamConcluidas() {
        return (root, query, builder) -> builder.notEqual(root.get("status"), StatusTask.CONCLUSAO);
    }

}
