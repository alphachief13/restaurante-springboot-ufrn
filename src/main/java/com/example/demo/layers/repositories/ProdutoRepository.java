package com.example.demo.layers.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.layers.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
     @Query("SELECT c FROM Produto c WHERE c.nome_produto LIKE :nome_produto")

    List<Object[]> findProdutosAndData(String nomeProduto);

	List<Object[]> findAllProdutos();
}
