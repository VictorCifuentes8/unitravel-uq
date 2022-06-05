package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorHotelRepo extends JpaRepository<AdministradorHotel, String> {

    Optional<AdministradorHotel> findByEmail(String correo);

    Optional<AdministradorHotel> findByPasswordAndEmail(String password, String email);
}
