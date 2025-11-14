package com.br.crud_pessoa.exception;

public class EnderecoNaoEncontradoException extends RuntimeException {
    public EnderecoNaoEncontradoException(Long id) {
        super("Endereço com ID " + id + "não encontrado");
    }
}
