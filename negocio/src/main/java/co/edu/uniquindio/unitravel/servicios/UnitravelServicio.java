package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import java.util.List;

public interface UnitravelServicio {

    // Validar login de los usuarios
    Persona validarLogin(String email, String password) throws Exception;


    //Listar ciudades
    List<Ciudad> listarCiudades();

    //Obtener Ciudad dado el codigo
    Ciudad obtenerCiudad(Integer codigo)throws Exception;

    //Funciones adicionales

    List<AdministradorHotel> listarAdminsHotel();

    List<Caracteristica> listarCaracteristicasHabitacion();

    List<Caracteristica> listarCaracteristicasHotel();

    Caracteristica obtenerCaracteristica(Integer id) throws Exception;

    Cama obtenerCama(Integer codigo) throws Exception;

    //Obtener un hotel por codigo
    Hotel obtenerHotelCodigo(Integer codigo)throws Exception;

    void crearComentario(Comentario comentario);

    List<Cama> listarCamas();
}

