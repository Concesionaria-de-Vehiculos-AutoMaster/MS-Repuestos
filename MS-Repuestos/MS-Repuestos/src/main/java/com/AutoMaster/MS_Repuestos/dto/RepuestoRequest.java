package com.AutoMaster.MS_Repuestos.dto;
import lombok.Data;

@Data
public class RepuestoRequest {
    private String nombre;
    private String marca;
    private Double precio;
    private Integer stock;
}