package com.automaster.msrepuestos.controller;

import com.automaster.msrepuestos.dto.RepuestoRequestDTO;
import com.automaster.msrepuestos.dto.RepuestoResponseDTO;
import com.automaster.msrepuestos.service.RepuestoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/repuestos")
@Tag(name = "Repuesto", description = "Operaciones relacionadas con los Repuestos en Stock")
public class RepuestoController {

    @Autowired
    private RepuestoServiceImpl repuestoService;

    @PostMapping
    @Operation(summary = "Crear nuevo respuesto", description = "Creacion de un nuevo repuesto ")
    public ResponseEntity<RepuestoResponseDTO> crearRepuesto(@Valid @RequestBody RepuestoRequestDTO request) {
        log.info("Petición POST entrante para crear repuesto");
        RepuestoResponseDTO response = repuestoService.guardarRepuesto(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping
    @Operation(summary = "Listar todos los repuestos", description = "Obtiene una lista de todos los repuestos en stock")
    public ResponseEntity<List<RepuestoResponseDTO>> listarRepuestos() {
        log.info("Petición GET entrante para listar todos los repuestos");
        List<RepuestoResponseDTO> response = repuestoService.listarTodos();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener repuesto", description = "Obtiene un repuesto mediante un ID")
    public ResponseEntity<RepuestoResponseDTO> obtenerRepuesto(@PathVariable Long id) {
        log.info("Petición GET entrante para buscar repuesto");
        RepuestoResponseDTO response = repuestoService.buscarPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // --- RUTA PARA ELIMINAR ---
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Repuesto", description = "Elimina un repuesto del inventario usando su ID")
    public ResponseEntity<Void> eliminarRepuesto(@PathVariable Long id) {
        log.info("Petición REST DELETE entrante para eliminar el repuesto ID: {}", id);
        repuestoService.eliminarRepuesto(id);

        // Retornamos 204 No Content confirmando la eliminación
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}