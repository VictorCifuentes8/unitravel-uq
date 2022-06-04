package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador, String> {

    @Query("select c from Ciudad c where c.codigo = :codigoCiudad")
    Optional<Ciudad> obtenerCiudadId(int codigoCiudad);

    @Query("select v from Vuelo v where v.codigo = :codigoVuelo")
    Optional<Vuelo> obtenerVueloId(int codigoVuelo);

    Optional<Administrador> findByNombre(String nombre);

    Optional<Administrador> findByEmail(String correo);

    @Query("select a from AdministradorHotel a where a.cedula = :cedulaAdministradorHotel")
    Optional<AdministradorHotel> obtenerAdministradorHotelId(String cedulaAdministradorHotel);

    Optional<Administrador>findByPasswordAndEmail(String password, String email);

}
