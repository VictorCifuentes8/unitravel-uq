package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HabitacionRepo extends JpaRepository<Habitacion, Integer> {

    //Obtener habitación por numero
    Optional<Habitacion> findByNumero(int numero);

    //Obtener habitacion por nombre
    @Query("select h from Habitacion h where h.hotel.nombre = : nomHotel")
    Optional<Habitacion> obtenerHabitacionNombre(String nomHotel);
}
