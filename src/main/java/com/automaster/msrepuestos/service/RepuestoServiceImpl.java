package com.automaster.msrepuestos.service;

import com.automaster.msrepuestos.dto.RepuestoRequestDTO;
import com.automaster.msrepuestos.dto.RepuestoResponseDTO;
import com.automaster.msrepuestos.model.Repuesto;
import com.automaster.msrepuestos.repository.RepuestoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
public class RepuestoServiceImpl {

    @Autowired
    private RepuestoRepository repuestoRepository;

    public RepuestoResponseDTO guardarRepuesto(RepuestoRequestDTO request) {
        log.info("Iniciando registro de repuesto con SKU: {}", request.getSku());

        if (repuestoRepository.existsBySku(request.getSku())) {
            log.error("Rechazado: El SKU {} ya existe", request.getSku());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ya existe un repuesto con ese código SKU");
        }

        Repuesto repuesto = new Repuesto();
        repuesto.setSku(request.getSku());
        repuesto.setNombre(request.getNombre());
        repuesto.setCategoria(request.getCategoria());
        repuesto.setPrecio(request.getPrecio());
        repuesto.setStockDisponible(request.getStockDisponible());

        Repuesto guardado = repuestoRepository.save(repuesto);
        log.info("Repuesto registrado con ID: {}", guardado.getId());

        return mapearADTO(guardado);
    }

    public RepuestoResponseDTO buscarPorId(Long id) {
        log.info("Buscando repuesto con ID: {}", id);
        Repuesto repuesto = repuestoRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Repuesto ID {} no encontrado", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Repuesto no encontrado");
                });
        return mapearADTO(repuesto);
    }

    private RepuestoResponseDTO mapearADTO(Repuesto repuesto) {
        RepuestoResponseDTO dto = new RepuestoResponseDTO();
        dto.setId(repuesto.getId());
        dto.setSku(repuesto.getSku());
        dto.setNombre(repuesto.getNombre());
        dto.setCategoria(repuesto.getCategoria());
        dto.setPrecio(repuesto.getPrecio());
        dto.setStockDisponible(repuesto.getStockDisponible());
        return dto;
    }
}