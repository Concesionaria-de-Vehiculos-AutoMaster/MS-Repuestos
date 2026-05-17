package com.automaster.msrepuestos.controller;

import com.automaster.msrepuestos.dto.RepuestoRequestDTO;
import com.automaster.msrepuestos.dto.RepuestoResponseDTO;
import com.automaster.msrepuestos.service.RepuestoServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/repuestos")
public class RepuestoController {

    @Autowired
    private RepuestoServiceImpl repuestoService;

    @PostMapping
    public ResponseEntity<RepuestoResponseDTO> crearRepuesto(@Valid @RequestBody RepuestoRequestDTO request) {
        log.info("Petición POST entrante para crear repuesto");
        RepuestoResponseDTO response = repuestoService.guardarRepuesto(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepuestoResponseDTO> obtenerRepuesto(@PathVariable Long id) {
        log.info("Petición GET entrante para buscar repuesto");
        RepuestoResponseDTO response = repuestoService.buscarPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}