package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

import java.time.LocalDateTime;
import java.util.List;

public interface ClienteServicio {


    //Gestionar Cliente

    //Registrarse
    Cliente registrarCliente(Cliente cliente)throws Exception;
    //Actualizar cliente
    public Cliente actualizarCliente(Cliente cliente) throws Exception;
    //Obtener cliente por la cedula
    Cliente obtenerCliente(String codigo)throws Exception;
    //eliminar Cliente
    void eliminarCliente(String cedula)throws Exception;
    //Listar todos los Clientes
    List<Cliente> listarClientes();
    //Buscar cliente por Email.
    public Cliente buscarEmail(String email) throws Exception;

    /*
    //Recuperar contraseñas usando correo electrónico.
    String recuperarContrasenia(String email) throws Exception;
    */

    //Funcionalidades adicionales

    //Buscar vuelos por ciudad destino
    List<Vuelo> vuelosDestino(String ciudadDestino) throws Exception;

    Silla crearReservaSilla(int codigo, Reserva reserva, Vuelo vuelo);

    //obtener una silla
    Silla obtenerSilla(Vuelo vuelo, int codigoSilla);

    //Buscar hoteles por la ciudad de destino
    List<Hotel> buscarHotelesPorDestino(String nombreCiudad) throws Exception;

    //Buscar Hoteles por el nombre
    List<Hotel> buscarHotelesPorNombre(String nombreHotel);


    List<Hotel> listarHoteles();

    List<Habitacion> listarHabitaciones();

    List<Ciudad> listarCiudades();


    Habitacion obtenerHabitacionCodigo(int numero) throws Exception;

    Habitacion obtenerHabitacionNombre(String nombreHotel) throws Exception;

    //Gestionar reservas.
    Reserva realizarReserva(LocalDateTime fechaInicio, LocalDateTime fechaFin, int cantidadPersonasMayores,
                            int cantidadPersonasMenores, Cliente cliente,
                            List<Habitacion> habitaciones, Vuelo vuelo)throws Exception;

    List<Silla> generarListaReservaSilla(int cantidadPersonas, Reserva reserva, Vuelo vuelo);



    ReservaHabitacion crearReservaHabitacion(int codigo, Habitacion habitacion, Reserva reserva);

}
