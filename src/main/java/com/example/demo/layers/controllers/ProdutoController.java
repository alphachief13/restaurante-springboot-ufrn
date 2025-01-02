package com.example.demo.layers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layers.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{nomeProduto}")
    public List<Object[]> obterProduto(@PathVariable String 
    nomeProduto) {
        return produtoService.obterOProdutoEData(nomeProduto);
    }
    
    @GetMapping("/todas")
    public List<Object[]> obterTodasAsMercadorias(){
        return produtoService.obterTodosOsProdutos();
    }
}