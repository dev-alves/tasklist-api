package com.tasklist.domain.model;

import lombok.Getter;

@Getter
public enum StatusTask {
    NOVA("NOVA"),
    EM_ANDAMENTO("Em andamento"),
    CONCLUSAO("Conclusão"),
    ARQUIVADO("Arquivado"),
    FINALIZADO("Finalizado");

    private String descricao;

    StatusTask(String descricao) {
        this.descricao = descricao;
    }

}
