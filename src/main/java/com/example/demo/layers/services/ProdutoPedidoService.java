package com.example.demo.layers.services;

import com.example.demo.layers.entities.Pedido;
import com.example.demo.layers.entities.Produto;
import com.example.demo.layers.entities.ProdutoPedido;
import com.example.demo.layers.repositories.ProdutoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoPedidoService {

    @Autowired
    private ProdutoPedidoRepository produtoPedidoRepository;

    // Salvar um novo ProdutoPedido
    public ProdutoPedido save(ProdutoPedido produtoPedido) {
        return produtoPedidoRepository.save(produtoPedido);
    }

    // Obter todos os ProdutoPedidos
    public List<ProdutoPedido> findAll() {
        return produtoPedidoRepository.findAll();
    }

    // Obter ProdutoPedido por ID
    public Optional<ProdutoPedido> findById(Long id) {
        return produtoPedidoRepository.findById(id);
    }

    // Deletar ProdutoPedido por ID
    public void delete(Long id) {
        produtoPedidoRepository.deleteById(id);
    }
    
    public List<ProdutoPedido> findProdutosByPedidoId(Long pedidoId) {
        return produtoPedidoRepository.findByPedidoId(pedidoId);
    }
}
