package com.cotacao.projetoSantander.exceptions;

//Identificando que essa classe é uma exeção.
public class BusinessException extends RuntimeException {

    public BusinessException(String menssage){
        super(menssage);
    }

}
