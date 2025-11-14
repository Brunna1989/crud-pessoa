package com.br.crud_pessoa.controller;

import com.br.crud_pessoa.model.Endereco;
import com.br.crud_pessoa.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping
    public Endereco criar(@RequestBody Endereco endereco) {
        return enderecoService.criarEndereco(endereco);
    }

    @GetMapping
    public List<Endereco> listar() {
        return enderecoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Endereco buscar(@PathVariable Long id) {
        return enderecoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Endereco atualizar(@PathVariable Long id, @RequestBody Endereco endereco) {
        return enderecoService.atualizarEndereco(id, endereco);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
    }





}
