package com.automaster.msrepuestos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "repuestos")
@Data
public class Repuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String sku; // Código único de la pieza

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private String categoria; // Ej: "Frenos", "Filtros", "Accesorios"

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Integer stockDisponible;
}