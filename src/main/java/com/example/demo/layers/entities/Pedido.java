package com.example.demo.layers.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(nullable = false)
    private int mesa;

    public Long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getMesa() {
        return mesa;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

}
