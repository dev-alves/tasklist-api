package com.tasklist.api.exceptionhandler;

import com.tasklist.domain.exception.EntidadeNaoEncontradaException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler  extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult bindResult = ex.getBindingResult();
        List<FieldError> camposDeErro = bindResult.getFieldErrors();

        return super.handleMethodArgumentNotValid(ex, headers, status, request);

    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleHttpMessageNotReadable(ex, headers, status, request);
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex, WebRequest request) {

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        TipoProblema tipoProblema = TipoProblema.ENTIDADE_NAO_ENCONTRADA;
        String detalhes = ex.getMessage();

        Problema problema = criarProblemaBuilder(httpStatus, tipoProblema, detalhes);
        return handleExceptionInternal(ex, problema, new HttpHeaders(), httpStatus, request);
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<?> handleWebExchangeBindException(Exception ex, WebRequest request) {
        System.out.println("Message: "+ ex.getMessage());
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_GATEWAY, request);
    }

    private Problema criarProblemaBuilder(HttpStatus httpStatus, TipoProblema tipoProblema, String detalhes) {
        return Problema.builder()
                .status(httpStatus.value())
                .titulo(tipoProblema.getTitulo())
                .tipo(tipoProblema.getUri())
                .detalhes(detalhes)
                .build();
    }
}
