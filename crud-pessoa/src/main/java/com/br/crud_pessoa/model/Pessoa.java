package com.br.crud_pessoa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pessoas", uniqueConstraints = {@UniqueConstraint(columnNames = "cpf")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome deve ser obrigatório")
    private String nome;

    private LocalDate dataNascimento;

    @NotBlank(message = "O campo CPF deve ser obrigatório")
    @Column(nullable = false, unique = true)
    private String cpf;

    @Builder.Default
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Endereco> enderecos = new ArrayList<>();
}




