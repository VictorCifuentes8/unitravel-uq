package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Persona;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, String> {

    @Query("select c from Cliente c where c.nombre = :nombre2")
    List<Cliente> clientesEncontrados(String nombre2);

    List<Cliente>findAllByNombre(String nombre);

    @Query("select c from Cliente c where c.email = ?1 and c.password = ?2")
    Optional<Cliente>clientesEncontrados2(String email, String contraseña);

    Optional<Cliente> findByEmailAndPassword(String email, String password);

    @Query("select c,r from Cliente c left join c.reservas r where r.cliente.cedula = :cedula")
    List<Reserva> obtenerReservas(String cedula);

    Optional<Cliente> findByEmail(String correo);

    @Query("select true from Cliente c where c.email = :email or c.password = :password")
    Boolean comprobarEmailAndContrasenia(String email, String password);
    //Cliente comprobarEmailAndContrasenia(String email, String password);

    @Query("select true from Cliente c where c.email = :email or c.password = :password")
    Optional<Boolean> comprobarEmailAndContrasenia2(String email, String password);
    //Cliente comprobarEmailAndContrasenia(String email, String password);

    Optional<Cliente> findByCedula(String cedula);

    Page<Cliente> findAll(Pageable pageable);

    @Query("select c.email, e from Cliente c left join c.comentarios e")
    List<Object[]> emailComentariosUsuario();

    @Query("select distinct t from Cliente c join c.telefonos t")
    List<String> obtenerUsuariosTelefono();

}
