package com.tasklist.domain.exception;

public class TaskNaoEncontradaException extends EntidadeNaoEncontradaException {

    public TaskNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

}
