package com.br.crud_pessoa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@Table(name = "enderecos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @NotBlank(message = "O campo estado deve ser obrigatório.")
    private String estado;

    @NotBlank(message = "O campo cidade deve ser obrigatório.")
    private String cidade;

    @NotBlank(message = "O campo CEP deve ser obrigatório.")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    @ToString.Exclude
    private Pessoa pessoa;

}






