package com.cotacao.projetoSantander.exceptions;

import com.cotacao.projetoSantander.util.MessageUtil;

public class NotFoundException extends RuntimeException {

    public NotFoundException(){
        super(MessageUtil.NAO_ENCONTRADO);
    }

}
