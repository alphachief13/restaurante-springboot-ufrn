package com.example.demo.layers.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;  // Importar a anotação

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    // Usando @JsonIgnore para evitar recursão infinita
    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<Produto> produtos;

    public Long getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
