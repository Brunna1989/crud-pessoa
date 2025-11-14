package com.br.crud_pessoa.service;

import com.br.crud_pessoa.exception.EnderecoNaoEncontradoException;
import com.br.crud_pessoa.model.Endereco;
import com.br.crud_pessoa.respository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    public Endereco buscarPorId(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new EnderecoNaoEncontradoException(id));
    }

    public Endereco atualizarEndereco(Long id, Endereco novo) {

        Endereco endereco = buscarPorId(id);

        endereco.setRua(novo.getRua());
        endereco.setNumero(novo.getNumero());
        endereco.setBairro(novo.getBairro());
        endereco.setCidade(novo.getCidade());
        endereco.setEstado(novo.getEstado());
        endereco.setCep(novo.getCep());

        return enderecoRepository.save(endereco);
    }

    public void deletarEndereco(Long id) {
        Endereco endereco = buscarPorId(id);
        enderecoRepository.delete(endereco);
    }



}
