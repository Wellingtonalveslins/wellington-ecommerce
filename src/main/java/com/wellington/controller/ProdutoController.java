package com.wellington.controller;

import com.wellington.model.Produto;
import com.wellington.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    // criar produto
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    // listar todos
    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    // buscar por id
    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // deletar
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
    // atualizar
@PutMapping("/{id}")
public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
    produto.setId(id);
    return service.salvar(produto);
}
}