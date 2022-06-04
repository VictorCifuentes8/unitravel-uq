package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Silla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SillaRepo extends JpaRepository<Silla, Integer> {
    //Obtener el precio de una silla
    @Query("select s.precio from Silla s where s.posicion = :posicion")
    Double precioSilla(String posicion);

    //Obtener la posicion de una silla
    Optional<Silla> findByPosicion(String posicion);

    //obtener sillas
    @Query("select s from Silla s where s.vuelo = :vueloCodigo and s.codigo = :codigoSilla")
    Silla obtenerSilla(int vueloCodigo, int codigoSilla);

    //comprobar si la silla esta disponible
//    @Query("select s from Silla s where s.codigo = ?1 and s.estado = 'Disponible'")
//    Optional<Silla> sillaDisponible(int codigo);
}
