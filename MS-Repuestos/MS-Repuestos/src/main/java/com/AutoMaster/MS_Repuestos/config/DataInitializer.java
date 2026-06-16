package com.AutoMaster.MS_Repuestos.config;
import com.AutoMaster.MS_Repuestos.model.Repuesto;
import com.AutoMaster.MS_Repuestos.repository.RepuestoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// Asegúrate de importar tu entidad y tu repositorio, por ejemplo:
// import com.automaster.msrepuestos.model.Repuesto;
// import com.automaster.msrepuestos.repository.RepuestoRepository;

@Component
@RequiredArgsConstructor // <-- Agregamos esta anotación (Estándar de tu compañero)
public class DataInitializer implements CommandLineRunner {

    // Quitamos @Autowired y usamos "private final"
    private final RepuestoRepository repuestoRepository;

    @Override
    public void run(String... args) throws Exception {

        // Verificamos si la tabla de repuestos está vacía
        if (repuestoRepository.count() == 0) {

            System.out.println("No se encontraron repuestos. Insertando datos de prueba...");

            // Creamos algunos repuestos
            Repuesto repuesto1 = new Repuesto();
            repuesto1.setNombre("Amortiguador Delantero");
            repuesto1.setMarca("Monroe");
            repuesto1.setPrecio(85.50);
            repuesto1.setStock(20);

            Repuesto repuesto2 = new Repuesto();
            repuesto2.setNombre("Pastillas de Freno");
            repuesto2.setMarca("Brembo");
            repuesto2.setPrecio(45.00);
            repuesto2.setStock(50);

            Repuesto repuesto3 = new Repuesto();
            repuesto3.setNombre("Filtro de Aceite");
            repuesto3.setMarca("Bosch");
            repuesto3.setPrecio(12.99);
            repuesto3.setStock(100);

            // Los guardamos todos de golpe en la base de datos
            // Arrays.asList ahora funcionará porque importamos java.util.Arrays y java.util.List
            List<Repuesto> repuestosIniciales = Arrays.asList(repuesto1, repuesto2, repuesto3);
            repuestoRepository.saveAll(repuestosIniciales);

            System.out.println("¡Datos de prueba insertados con éxito!");
        }
    }
}