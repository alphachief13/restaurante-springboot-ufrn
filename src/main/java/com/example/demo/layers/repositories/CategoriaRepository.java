package com.example.demo.layers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.layers.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
