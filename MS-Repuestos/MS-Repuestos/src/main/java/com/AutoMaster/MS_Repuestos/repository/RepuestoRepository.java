package com.AutoMaster.MS_Repuestos.repository;

import com.AutoMaster.MS_Repuestos.model.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto, Long> {
}