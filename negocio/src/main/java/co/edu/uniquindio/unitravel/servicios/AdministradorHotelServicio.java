package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

import java.util.List;

public interface AdministradorHotelServicio {


    //Obtener el administradorHotel dado su codigo
    AdministradorHotel obtenerAdminHotel(String codigo)throws Exception;


    //Gestionar Habitaciones

    //Crear habitacion
    Habitacion crearHabitacion(Habitacion habitacion) throws Exception;



    //Gestionar Hoteles



    //Obtener un hotel por nombre
    Hotel obtenerHotel(String nombre)throws Exception;
    //Crear hotel
    Hotel crearHotel(Hotel hotel) throws Exception;
    //Eliminar hotel
    void eliminarHotel(String nombre) throws Exception;
    //Modificar la información del hotel
    Hotel modificarHotel(Hotel hotel) throws Exception;
    //Listar los hoteles registrados.
    List<Hotel> listarHoteles();


}
