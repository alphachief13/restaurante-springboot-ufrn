package com.example.demo.layers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layers.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Object[]> obterOProdutoEData(String nomeProduto) {
        return produtoRepository.findProdutosAndData(nomeProduto);
    }

    public List<Object[]> obterTodosOsProdutos() {
        return produtoRepository.findAllProdutos();
    }
}
