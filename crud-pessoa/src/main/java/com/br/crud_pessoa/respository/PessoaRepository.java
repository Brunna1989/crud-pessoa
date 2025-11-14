package com.br.crud_pessoa.respository;

import com.br.crud_pessoa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Optional<Pessoa>findByCpf(String cpf);;

    boolean existeByCpf(String cpf);
}
