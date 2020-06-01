package com.tasklist.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum TipoProblema {

    ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada");

    private String titulo;
    private String uri;

    TipoProblema(String path, String titulo) {
        this.uri = "http://localhost:8080" + path;
        this.titulo = titulo;
    }
}
