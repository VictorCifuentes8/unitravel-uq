package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;


import java.util.Optional;

public interface AdministradorServicio {

    //Gestionar Destinos

    //Obtener ciudad a traves del codigo
    public Optional<Ciudad> obtenerCiudad(int codigo);
    //Crear
    Ciudad crearCiudad(int codigo,String nombreCiudad) throws Exception;
    //Eliminar
    void eliminarCiudad(int codigoCiudad) throws Exception;

    //Gestionar Vuelos

    //Obtener vuelo a traves del codigo
    public Optional<Vuelo> obtenerVuelo(int codigo);

    //Crear Vuelos
    Vuelo crearVuelo(int codigo, int estado, String aerolinea, int capacidad)throws Exception;

    //Eliminar Vuelos
    void eliminarVuelo(int codigoVuelo)throws Exception;


    //Gestionar administradores de hoteles.

    //Obtener administrador de hotel a traves de la cedula
    public Optional<AdministradorHotel> obtenerAdministradorHotel(String cedula)throws Exception;

    //Crear
    AdministradorHotel crearAdministradorHotel(String cedula, String nombre,
                                               int edad, String email, String password)throws Exception;
    //Eliminar
    void eliminarAdministradorHotel(String cedula);
    //Crear silla
    Silla crearSilla(int codigo, int posicion, double precio, Vuelo vuelo);
    //Obtener silla
    boolean obtenerSilla(int codigo);

}
