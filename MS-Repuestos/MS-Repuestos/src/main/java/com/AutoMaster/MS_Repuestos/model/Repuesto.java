package com.AutoMaster.MS_Repuestos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indica que esta clase es una tabla de la base de datos
@Table(name = "repuestos") // (Opcional) Define el nombre exacto de la tabla
public class Repuesto {

    @Id // Define que este campo es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long id;

    private String nombre;
    private String marca;
    private Double precio;
    private Integer stock;

    // --- CONSTRUCTORES ---
    public Repuesto() {
    }

    public Repuesto(Long id, String nombre, String marca, Double precio, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
    }

    // --- GETTERS Y SETTERS ---
    // (Son necesarios para que Spring pueda leer y escribir los datos)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}