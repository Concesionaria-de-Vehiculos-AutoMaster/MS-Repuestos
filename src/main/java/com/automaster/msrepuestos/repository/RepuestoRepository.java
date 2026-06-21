package com.automaster.msrepuestos.repository;

import com.automaster.msrepuestos.model.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto, Long> {
    boolean existsBySku(String sku);
    Optional<Repuesto> findBySku(String sku);
}