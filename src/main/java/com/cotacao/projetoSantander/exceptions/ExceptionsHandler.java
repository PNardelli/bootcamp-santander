package com.cotacao.projetoSantander.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Vai interceptar o exception e retonar o codigo do erro correto.
@ControllerAdvice //Deixa ouvindo se cair um throw, ele captura.
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ExceptionResponse> handlerSecurity(BusinessException businessException){
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExceptionResponse(businessException.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ExceptionResponse> notfound(NotFoundException notFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(notFoundException.getMessage()));
    }


}
