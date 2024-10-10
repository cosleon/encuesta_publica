package com.example.encuesta.repository;

import com.example.encuesta.entity.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List; //al hacer intro me lo recomendo la aplicacion asique importado queda

@Repository

public interface EncuestaRepository extends JpaRepository<Encuesta, Long> {
    // Filtrar encuestas por nivel de satisfacción
    List<Encuesta> findByNivelSatisfaccion(String nivelSatisfaccion);

    // Calcular el promedio de edad
    @Query("SELECT AVG(e.edad) FROM Encuesta e")
    Double promedioEdad();

    // Obtener la distribución de niveles de satisfacción
    @Query("SELECT e.nivelSatisfaccion, COUNT(e) * 100.0 / (SELECT COUNT(e) FROM Encuesta e) FROM Encuesta e GROUP BY e.nivelSatisfaccion")
    List<Object[]> distribucionSatisfaccion();
}
