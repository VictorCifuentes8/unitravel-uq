package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.dto.hotelesCiudadDTO;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad, Integer> {

    Optional<Ciudad> findByNombre(String nombreCiudad);

    @Query("select c.hoteles from Ciudad c where c.codigo = :idCiudad")
    List<Hotel> nombresHoteles(int idCiudad);

    //Cree una consulta que permita contar el número de hoteles que hay por cada ciudad. Use GROUP BY.
    @Query("select new co.edu.uniquindio.unitravel.entidades.dto.hotelesCiudadDTO(h.ciudad, count(h)) from Hotel h group by h.ciudad")
    List<hotelesCiudadDTO> hotelesDeLaCiudad();
}
