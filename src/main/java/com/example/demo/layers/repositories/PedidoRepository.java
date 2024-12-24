package com.example.demo.layers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.layers.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}
