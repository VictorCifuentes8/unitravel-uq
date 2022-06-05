package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {

    //obtener hoteles por numero de estrellas
    List<Hotel> findAllByNumEstrellas(int numEstrellas);

    //obtener hoteles por nombre
    @Query("select h from Hotel h where lower(h.nombre) like concat('%',lower(:nombre), '%' ) ")
    List<Hotel> buscarPorNombreHotel(String nombre);

    //obtener hoteles por codigo de la ciudad
    @Query("select h from Hotel h where h.ciudad.codigo = :codigoCiudad")
    List<Hotel> listarHotelesCiudad( Integer codigoCiudad);

    //Obtener hoteles por codigo
    Optional<Hotel> findByCodigo (int codigo);

    //Obtener el hotel dado el nombre
    Optional<Hotel> findByNombre (String nombreHotel);

    List<Hotel> findAllByCodigo(int codigo);

    //Obtener los hoteles dado el nombre de una ciudad
    @Query("select h.nombre from Hotel h where h.ciudad.nombre= :nombreCiudad")
    List<Hotel> listarHotelesCiudad(String nombreCiudad);

    //Cree una consulta que permita determinar el número de reservas que tiene un hotel específico cuya
    //fecha de inicio de reserva aún no haya pasado.
    @Query("select count(r) from Reserva r join r.reservaHabitacion h where h.habitacion.hotel.codigo = :codigoHotel and r.fechaInicio > CURRENT_DATE ")
    int reservasHotel(int codigoHotel);
    //List<Reserva> reservasHotel (int codigoHotel);

    //Cree una consulta que permita determinar qué hoteles no tienen comentarios. Use IS EMPTY.
    @Query("select h from Hotel h where h.comentario is empty ")
    List<Hotel> hotelesNoComentados();

    //Cree una consulta que devuelva una lista con todos los hoteles que contengan en su nombre una cadena de búsqueda. Use LIKE.
    @Query("select h from Hotel h where h.nombre like '%tel%'")
    List<Hotel> busquedaNombreHotelPorCadena();



}

