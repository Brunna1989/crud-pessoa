package com.br.crud_pessoa.exception;

public class PessoaNaoEncontradaException extends RuntimeException {
    public PessoaNaoEncontradaException(Long id) {
        super("Pessoa com ID " + id + "não encontrada.");
    }
}
