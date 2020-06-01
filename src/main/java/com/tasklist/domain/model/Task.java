package com.tasklist.domain.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Data
@DynamicUpdate
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O titulo é obrigatório")
    private String titulo;

    @Enumerated(EnumType.ORDINAL)
    private StatusTask status = StatusTask.NOVA;

    @NotBlank(message = "A descricão é obrigatório")
    private String descricao;

    private LocalDate dataCriacao = LocalDate.now();

    private LocalDate dataEdicao;

    private LocalDate dataRemocao;

    private LocalDate dataConclusao;

    private LocalDate dataFinal;

}
