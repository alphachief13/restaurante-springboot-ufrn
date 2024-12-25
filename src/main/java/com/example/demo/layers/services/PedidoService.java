package com.example.demo.layers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layers.repositories.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Object[]> obterProdutosEDataPedidos(String nomeCliente) {
        return pedidoRepository.findProdutosAndDataPedidosByClienteNome(nomeCliente);
    }

    public List<Object[]> obterTodasOsPedidos() {
        return pedidoRepository.findAllPedidos();
    }
}
