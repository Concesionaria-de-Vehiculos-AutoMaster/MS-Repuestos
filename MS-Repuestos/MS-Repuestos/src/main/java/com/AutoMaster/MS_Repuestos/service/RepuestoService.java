package com.AutoMaster.MS_Repuestos.service;
import com.example.repuestos.model.Repuesto;
import com.example.repuestos.repository.RepuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RepuestoService {

    @Autowired
    private RepuestoRepository repository;

    // 1. Obtener todos los repuestos
    public List<Repuesto> listarTodos() {
        return repository.findAll();
    }

    // 2. Buscar un repuesto por su ID
    public Optional<Repuesto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // 3. Guardar un nuevo repuesto (o actualizar si ya existe)
    public Repuesto guardar(Repuesto repuesto) {
        return repository.save(repuesto);
    }

    // 4. Eliminar un repuesto
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}