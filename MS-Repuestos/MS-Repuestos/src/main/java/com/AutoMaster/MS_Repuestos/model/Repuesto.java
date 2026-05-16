package com.AutoMaster.MS_Repuestos.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "repuestos")
@Data // Si usas Lombok, esto crea getters/setters. Si no, agrégalos manualmente.
public class Repuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String marca;
    private Double precio;
    private Integer stock;
}