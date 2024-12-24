package com.example.demo.layers.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public String getEmail() {
        return email;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
