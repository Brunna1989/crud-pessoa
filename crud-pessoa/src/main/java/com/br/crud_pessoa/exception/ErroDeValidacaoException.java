package com.br.crud_pessoa.exception;

public class ErroDeValidacaoException extends RuntimeException{
    public ErroDeValidacaoException(String mensagem) {
        super(mensagem);

    }
}
