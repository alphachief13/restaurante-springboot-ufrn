package com.example.demo.layers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layers.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
 
    @Autowired
    CategoriaService categoriaService;
    
}
