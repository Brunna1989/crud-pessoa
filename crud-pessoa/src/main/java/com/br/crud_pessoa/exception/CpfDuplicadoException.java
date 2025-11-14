package com.br.crud_pessoa.exception;

public class CpfDuplicadoException extends RuntimeException{
    public CpfDuplicadoException(String cpf) {
        super("CPF " + cpf + "já está cadastrado");
    }
}
