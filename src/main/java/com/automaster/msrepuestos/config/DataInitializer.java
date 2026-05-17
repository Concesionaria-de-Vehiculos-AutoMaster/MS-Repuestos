package com.automaster.msrepuestos.config;

import com.automaster.msrepuestos.model.Repuesto;
import com.automaster.msrepuestos.repository.RepuestoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RepuestoRepository repuestoRepository;

    @Override
    public void run(String... args) throws Exception {
        if (repuestoRepository.count() == 0) {
            log.info("Cargando catálogo inicial de repuestos...");

            Repuesto r1 = new Repuesto();
            r1.setSku("FIL-ACEITE-01");
            r1.setNombre("Filtro de Aceite Original");
            r1.setCategoria("Filtros");
            r1.setPrecio(15000.0);
            r1.setStockDisponible(50);
            repuestoRepository.save(r1);

            Repuesto r2 = new Repuesto();
            r2.setSku("FREN-PAST-01");
            r2.setNombre("Pastillas de Freno Cerámicas");
            r2.setCategoria("Frenos");
            r2.setPrecio(45000.0);
            r2.setStockDisponible(20);
            repuestoRepository.save(r2);

            log.info("Catálogo inicial cargado con éxito.");
        }
    }
}