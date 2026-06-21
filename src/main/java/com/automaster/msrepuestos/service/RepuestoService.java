package com.automaster.msrepuestos.service;

import com.automaster.msrepuestos.dto.RepuestoRequestDTO;
import com.automaster.msrepuestos.dto.RepuestoResponseDTO;
import java.util.List;

public interface RepuestoService {

    // 1. CREAR: Registra un nuevo repuesto en el inventario
    RepuestoResponseDTO crearRepuesto(RepuestoRequestDTO request);

    // 2. LEER (Individual): Busca un repuesto específico por su ID
    RepuestoResponseDTO obtenerPorId(Long id);

    // 3. LEER (General): Obtiene el catálogo completo de repuestos
    List<RepuestoResponseDTO> listarTodos();

    // 4. ELIMINAR: Borra un repuesto del inventario usando su ID
    void eliminarRepuesto(Long id);

    // 💡 Opcional para el futuro - ACTUALIZAR STOCK:
    // RepuestoResponseDTO actualizarStock(Long id, Integer cantidadComprada);
}