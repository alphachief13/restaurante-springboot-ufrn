package com.example.demo.layers.controllers;

import com.example.demo.layers.entities.ProdutoPedido;
import com.example.demo.layers.services.ProdutoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtoPedido")
public class ProdutoPedidoController {

    @Autowired
    private ProdutoPedidoService produtoPedidoService;

    // Criar um ProdutoPedido
    @PostMapping
    public ResponseEntity<ProdutoPedido> createProdutoPedido(@RequestBody ProdutoPedido produtoPedido) {
        ProdutoPedido savedProdutoPedido = produtoPedidoService.save(produtoPedido);
        return ResponseEntity.status(201).body(savedProdutoPedido);
    }

    // Obter todos os ProdutoPedidos
    @GetMapping
    public List<ProdutoPedido> getAllProdutoPedidos() {
        return produtoPedidoService.findAll();
    }

    // Obter um ProdutoPedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoPedido> getProdutoPedidoById(@PathVariable Long id) {
        Optional<ProdutoPedido> produtoPedido = produtoPedidoService.findById(id);
        return produtoPedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Deletar um ProdutoPedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdutoPedido(@PathVariable Long id) {
        Optional<ProdutoPedido> produtoPedido = produtoPedidoService.findById(id);
        if (produtoPedido.isPresent()) {
            produtoPedidoService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
