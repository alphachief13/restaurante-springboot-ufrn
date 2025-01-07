package com.example.demo.layers.services;

import com.example.demo.layers.entities.Produto;
import com.example.demo.layers.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Salvar ou atualizar produto
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Obter todos os produtos
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    // Obter produto por ID
    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    // Deletar produto por ID
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
