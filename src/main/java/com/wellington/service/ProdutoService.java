package com.wellington.service;

import com.wellington.model.Produto;
import com.wellington.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    // salvar produto
    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    // listar todos
    public List<Produto> listar() {
        return repository.findAll();
    }

    // buscar por id
    public Produto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    // deletar
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}