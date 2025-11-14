package com.br.crud_pessoa.service;

import com.br.crud_pessoa.exception.CpfDuplicadoException;
import com.br.crud_pessoa.exception.PessoaNaoEncontradaException;
import com.br.crud_pessoa.model.Pessoa;
import com.br.crud_pessoa.respository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public Pessoa criarPessoa(Pessoa pessoa) {
        if (pessoaRepository.existsByCpf(pessoa.getCpf())) {
            throw new CpfDuplicadoException(pessoa.getCpf());
        }
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));

    }

    public Pessoa atualizarPessoa(Long id, Pessoa novosDados) {

        Pessoa pessoa = buscarPorId(id);

        pessoa.setNome(novosDados.getNome());
        pessoa.setCpf(novosDados.getCpf());
        pessoa.setDataNascimento(novosDados.getDataNascimento());

        pessoa.getEnderecos().clear();

        novosDados.getEnderecos().forEach(endereco -> {
            endereco.setPessoa(pessoa);
            pessoa.getEnderecos().add(endereco);
        });

        return pessoaRepository.save(pessoa);
    }

    public void deletarPessoa(Long id) {
        Pessoa pessoa = buscarPorId(id);
        pessoaRepository.delete(pessoa);
    }

    public int calcularIdade(Long id) {
        Pessoa pessoa = buscarPorId(id);

        if (pessoa.getDataNascimento() == null) {
            return 0;
        }

        return Period.between(pessoa.getDataNascimento(), LocalDate.now()).getYears();
    }



}
