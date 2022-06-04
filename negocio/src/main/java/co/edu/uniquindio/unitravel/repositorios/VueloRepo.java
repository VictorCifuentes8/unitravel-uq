package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.dto.VuelosPorCiudadDTO;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueloRepo extends JpaRepository<Vuelo, Integer> {

    //Cree un consulta que permita determinar cuántos vuelos salen de cada ciudad. Devuelva un DTO
    //con el nombre de la ciudad, el código del vuelo, el estado, el destino del vuelo y número de
    //registros.
    @Query("select new co.edu.uniquindio.unitravel.entidades.dto.VuelosPorCiudadDTO(v.ciudadOrigen, v.codigo, v.estado,v.ciudadDestino, count(v)) from Vuelo v group by v.ciudadOrigen")
    List<VuelosPorCiudadDTO> VuelosPorCiudad();

    // Obtener lista de vuelos por la ciudad de destino
    @Query("select v.codigo  from Vuelo v where v.ciudadDestino = :ciudadDestino")
    List<Vuelo> listarVuelosDestino (String ciudadDestino);

    //@Query("select v.ciudadOrigen, v.codigo, v.estado,v.ciudadDestino, count(v) from Vuelo v group by v.ciudadOrigen")
    //List<Object[]> VuelosPorCiudad();

}
