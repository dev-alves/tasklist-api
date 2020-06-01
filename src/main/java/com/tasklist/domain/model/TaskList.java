package com.tasklist.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task_list")
@Data
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Task> tasks;

    private Long posicao;

}
