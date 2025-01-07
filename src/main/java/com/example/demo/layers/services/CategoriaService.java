package com.example.demo.layers.services;

import com.example.demo.layers.entities.Categoria;
import com.example.demo.layers.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Salvar ou atualizar categoria
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Obter todas as categorias
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    // Obter categoria por ID
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    // Deletar categoria por ID
    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}
