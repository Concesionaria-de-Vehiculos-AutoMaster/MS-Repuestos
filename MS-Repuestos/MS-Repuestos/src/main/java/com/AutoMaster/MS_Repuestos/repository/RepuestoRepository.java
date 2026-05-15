package com.AutoMaster.MS_Repuestos.repository;

import com.example.repuestos.model.Repuesto;
import com.example.repuestos.service.RepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repuestos") // La URL base será http://localhost:8080/api/repuestos
public class RepuestoController {

    @Autowired
    private RepuestoService service;

    // 1. OBTENER TODOS LOS REPUESTOS
    @GetMapping
    public List<Repuesto> listar() {
        return service.listarTodos();
    }

    // 2. OBTENER UN REPUESTO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Repuesto> obtenerPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. CREAR UN NUEVO REPUESTO
    @PostMapping
    public Repuesto crear(@RequestBody Repuesto repuesto) {
        return service.guardar(repuesto);
    }

    // 4. ACTUALIZAR UN REPUESTO EXISTENTE
    @PutMapping("/{id}")
    public ResponseEntity<Repuesto> actualizar(@PathVariable Long id, @RequestBody Repuesto detallesRepuesto) {
        return service.buscarPorId(id).map(repuesto -> {
            repuesto.setNombre(detallesRepuesto.getNombre());
            repuesto.setMarca(detallesRepuesto.getMarca());
            repuesto.setPrecio(detallesRepuesto.getPrecio());
            repuesto.setStock(detallesRepuesto.getStock());
            return ResponseEntity.ok(service.guardar(repuesto));
        }).orElse(ResponseEntity.notFound().build());
    }

    // 5. ELIMINAR UN REPUESTO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}