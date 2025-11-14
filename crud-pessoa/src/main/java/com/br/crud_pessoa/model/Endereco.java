package com.br.crud_pessoa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da rua deve ser obrigatório.")
    private String rua;

    @NotBlank(message = "O campo número deve ser obrigatório.")
    private String numero;

    @NotBlank(message = "O campo bairro deve ser obrigatório.")
    private String bairro;

    @NotBlank(message = "O campo cidade deve ser obrigatório.")
    private String cidade;

    @NotBlank(message = "O campo CEP deve ser obrigatório.")
    private String cep;

    @ManyToMany
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;







}
