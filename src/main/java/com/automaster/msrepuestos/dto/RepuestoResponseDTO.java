package com.automaster.msrepuestos.dto;

import lombok.Data;

@Data
public class RepuestoResponseDTO {
    private Long id;
    private String sku;
    private String nombre;
    private String categoria;
    private Double precio;
    private Integer stockDisponible;
}