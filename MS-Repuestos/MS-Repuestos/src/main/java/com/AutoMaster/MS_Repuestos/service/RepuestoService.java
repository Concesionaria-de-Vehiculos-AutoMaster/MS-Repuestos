package com.AutoMaster.MS_Repuestos.service;

import com.AutoMaster.MS_Repuestos.dto.RepuestoRequest;
import com.AutoMaster.MS_Repuestos.exception.RepuestoException;
import com.AutoMaster.MS_Repuestos.model.Repuesto;
import com.AutoMaster.MS_Repuestos.repository.RepuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestoService {

    @Autowired
    private RepuestoRepository repository;

    public List<Repuesto> obtenerTodos() {
        return repository.findAll();
    }

    public Repuesto guardar(RepuestoRequest request) {
        Repuesto repuesto = new Repuesto();
        repuesto.setNombre(request.getNombre());
        repuesto.setMarca(request.getMarca());
        repuesto.setPrecio(request.getPrecio());
        repuesto.setStock(request.getStock());
        return repository.save(repuesto);
    }

    public Repuesto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RepuestoException("No se encontró el repuesto con ID: " + id));
    }
}