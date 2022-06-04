package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva, Integer> {

    Page<Reserva> findAll(Pageable pageable);

    @Query("select r.cliente.nombre, r.fechaReserva, rh.habitacion from Reserva r join r.reservaHabitacion rh where rh.habitacion.hotel.codigo = :codigoHotel and r.fechaInicio < :fecha ")
    List<Object[]> ObtenerDatos(int codigoHotel, LocalDate fecha);

    //Cree una consulta que calcule el valor total que ha gastado un usuario en reservas. Total por
    //reserva o total por todas las reservas.

    @Query("select r from Reserva r ")
    List<Reserva> listarReservas();

    @Query("select r.codigo,r.precioTotal, (select sum(r.precioTotal) from Reserva r where r.cliente.cedula = :cedula)  from Reserva r where r.cliente.cedula = :cedula")
    List<Object[]> ObtenerPrecioTotalReservasCliente(String cedula);

    //Cree una consulta que devuelva una lista de reservas y el detalle de cada reserva de un cliente
    //dado su código.
    //@Query("select r, rs, rh from Reserva r join r.reservaSilla rs, r.reservaHabitacion rh where r.cliente.cedula = :cedula")
    //List<Object[]> ObtenerTodoReserva(String cedula);

}
