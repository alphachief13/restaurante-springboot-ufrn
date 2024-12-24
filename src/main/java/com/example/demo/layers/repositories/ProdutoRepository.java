package com.example.demo.layers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.layers.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
