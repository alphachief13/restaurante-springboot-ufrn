package com.example.demo.layers.controllers;

import com.example.demo.layers.entities.Pedido;
import com.example.demo.layers.entities.ProdutoPedido;
import com.example.demo.layers.services.PedidoService;
import com.example.demo.layers.services.ProdutoPedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    private ProdutoPedidoService produtoPedidoService;

    @GetMapping("/{id}/produtos")
    public ResponseEntity<List<ProdutoPedido>> getProdutosDePedido(@PathVariable Long id) {
        List<ProdutoPedido> produtos = produtoPedidoService.findProdutosByPedidoId(id);
        return produtos.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(produtos);
    }
    
    // Criar um pedido
    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        Pedido savedPedido = pedidoService.save(pedido);
        return ResponseEntity.status(201).body(savedPedido);
    }

    // Obter todos os pedidos
    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.findAll();
    }

    // Obter um pedido por id
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.findById(id);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar um pedido
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        Optional<Pedido> existingPedido = pedidoService.findById(id);
        if (existingPedido.isPresent()) {
            pedido.setId(id);
            Pedido updatedPedido = pedidoService.save(pedido);
            return ResponseEntity.ok(updatedPedido);
        }
        return ResponseEntity.notFound().build();
    }

    // Deletar um pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.findById(id);
        if (pedido.isPresent()) {
            pedidoService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
