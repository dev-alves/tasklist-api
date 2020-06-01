package com.tasklist.domain.exception;

public class EntidadeNaoEncontradaException extends NegocioException {

    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public EntidadeNaoEncontradaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
