package com.AutoMaster.MS_Repuestos.controller;

import com.AutoMaster.MS_Repuestos.dto.RepuestoRequest;
import com.AutoMaster.MS_Repuestos.model.Repuesto;
import com.AutoMaster.MS_Repuestos.service.RepuestoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/repuestos")
@Tag(name="Repuestos", description = "Venta de accesorios y piezas.")
public class RepuestoController {

    @Autowired
    private RepuestoService service;

    @GetMapping
    @Operation(summary = "Obtener todos los repuestos ", description = "Obtiene una lista de todas los repuestos")
    public List<Repuesto> listar() {
        return service.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<Repuesto> crear(@RequestBody RepuestoRequest request) {
        return ResponseEntity.ok(service.guardar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Repuesto> obtenerUno(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}