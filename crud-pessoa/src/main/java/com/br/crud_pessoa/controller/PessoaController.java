package com.br.crud_pessoa.controller;

import com.br.crud_pessoa.model.Pessoa;
import com.br.crud_pessoa.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public Pessoa criar(@RequestBody Pessoa pessoa) {
        return pessoaService.criarPessoa(pessoa);
    }

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Pessoa buscar(@PathVariable Long id) {
        return pessoaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Pessoa atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return pessoaService.atualizarPessoa(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pessoaService.deletarPessoa(id);
    }

    @GetMapping("/{id}/idade")
    public int idade(@PathVariable Long id) {
        return pessoaService.calcularIdade(id);
    }



}
