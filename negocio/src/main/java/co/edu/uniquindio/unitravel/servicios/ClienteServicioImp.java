package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImp implements ClienteServicio{

    //Inicializacion de los repositorios necesarios.
    private ClienteRepo clienteRepo;
    private CiudadRepo ciudadRepo;
    private VueloRepo vueloRepo;
    private HotelRepo hotelRepo;
    private ComentarioRepo comentarioRepo;
    private ReservaRepo reservaRepo;
    private SillaRepo sillaRepo;
    private HabitacionRepo habitacionRepo;
    private ReservaSillaRepo reservaSillaRepo;
    private ReservaHabitacionRepo reservaHabitacionRepo;

    //Constructor repositorios.
    public ClienteServicioImp(ClienteRepo clienteRepo, CiudadRepo ciudadRepo, VueloRepo vueloRepo,
                              HotelRepo hotelRepo, ComentarioRepo comentarioRepo,
                              ReservaRepo reservaRepo,SillaRepo sillaRepo,
                              HabitacionRepo habitacionRepo )
    {
        this.clienteRepo = clienteRepo;
        this.vueloRepo = vueloRepo;
        this.hotelRepo = hotelRepo;
        this.comentarioRepo = comentarioRepo;
        this.reservaRepo = reservaRepo;
        this.sillaRepo = sillaRepo;
        this.habitacionRepo = habitacionRepo;
        this.ciudadRepo = ciudadRepo;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws Exception{
        Cliente clienteEncontrado = obtenerCliente(cliente.getCedula());
        if(clienteEncontrado != null){
            throw new Exception("Ya existe la cedula del cliente");
        }
        Cliente clienteEmail = buscarEmail(cliente.getEmail());
        if(clienteEmail != null){
            throw new Exception("El correo del cliente ya se encuentra registrado");
        }
        return clienteRepo.save(cliente);
    }

    public Cliente buscarEmail(String email) throws Exception{
        return clienteRepo.findByEmail(email).orElse(null);
    }

    public Boolean buscarEmailandPassword(Cliente cliente){
        return clienteRepo.comprobarEmailAndContrasenia(cliente.getEmail(),cliente.getPassword());
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws Exception{
        Cliente clienteEncontrado = obtenerCliente(cliente.getCedula());
        if(clienteEncontrado==null){
            throw new Exception("El cliente no existe");
        }
        return clienteRepo.save(cliente);
    }

    @Override
    public Cliente obtenerCliente(String codigo) throws Exception {
        return clienteRepo.findByCedula(codigo).orElse(null);
    }


    @Override
    public void eliminarCliente(String cedula) throws Exception{
        Cliente clienteEncontrado = obtenerCliente(cedula);
        if(clienteEncontrado==null){
            throw new Exception("El cliente no existe");
        }
        clienteRepo.delete(clienteEncontrado);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public List<Vuelo> vuelosDestino(String ciudadDestino) throws Exception {
        Optional<Ciudad> ciudad = ciudadRepo.findByNombre(ciudadDestino);
        if(ciudad.isEmpty()){
            throw new Exception("La ciudad no existe");
        }
        return vueloRepo.listarVuelosDestino(ciudadDestino);
    }


    @Override
    public List<Hotel> buscarHotelesPorDestino(String nombreCiudad) throws Exception {
        Optional<Ciudad> ciudad = ciudadRepo.findByNombre(nombreCiudad);
        if(ciudad.isEmpty()) {
            throw new Exception("La ciudad no existe");
        }
        return hotelRepo.listarHotelesCiudad(nombreCiudad);
    }

    @Override
    public List<Hotel> buscarHotelesPorNombre(String nombreHotel){
        return hotelRepo.buscarPorNombreHotel(nombreHotel);
    }

    @Override
    public List<Hotel> listarHoteles(){
        return hotelRepo.findAll();
    }

    @Override
    public List<Habitacion> listarHabitaciones(){
        return habitacionRepo.findAll();
    }
    @Override
    public List<Ciudad> listarCiudades(){
        return ciudadRepo.findAll();
    }


    @Override
    public Habitacion obtenerHabitacionCodigo(int numero) throws Exception {
        return habitacionRepo.findByNumero(numero).orElse(null);
    }

    @Override
    public Habitacion obtenerHabitacionNombre(String nombreHotel) throws Exception {
        return habitacionRepo.obtenerHabitacionNombre(nombreHotel).orElse(null);
    }

    @Override
    public Reserva realizarReserva(LocalDateTime fechaInicio, LocalDateTime fechaFin, int cantidadPersonasMayores,
                                   int cantidadPersonasMenores, Cliente cliente, List<Habitacion> habitaciones, Vuelo vuelo)throws Exception{

        double precioMayores = 0;
        double precioMenores = 0;
        double precioHabitacion = 0;
        double precioTotal = 0;

        Reserva reservaCliente = new Reserva();
        reservaCliente.setFechaInicio(fechaInicio);
        reservaCliente.setFechaFin(fechaFin);
        reservaCliente.setFechaReserva( LocalDateTime.now() );
        reservaCliente.setCantidadPersonasMenores(cantidadPersonasMenores);
        reservaCliente.setCantidadPersonasMayores(cantidadPersonasMayores);
        reservaCliente.setCliente(cliente);

        List<Silla> sillas = new ArrayList<>();

        if(vuelo != null){
            List<Silla> reservaSillasMayores = generarListaReservaSilla(cantidadPersonasMayores, reservaCliente, vuelo);
            precioMayores = reservaSillasMayores.stream().map(Silla::getPrecio).reduce(0.0, Double::sum);
            sillas.addAll(reservaSillasMayores);

            List<Silla> reservaSillasMenores = generarListaReservaSilla(cantidadPersonasMenores, reservaCliente, vuelo);
            for (int i = 0; i < cantidadPersonasMenores; i++) {
                precioMenores += reservaSillasMenores.get(i).getPrecio()*0.7;
            }
            sillas.addAll(reservaSillasMenores);
        }
        List<Reserva>listaReserva= reservaRepo.listarReservas();

        //validar que la ahbitación esté disponible
        for(int i =0; i < listaReserva.size();i++){
            if(listaReserva.get(i).getFechaFin().compareTo(fechaInicio)<0){
                for(int j =0; j < listaReserva.get(i).getReservaHabitacion().size();j++) {
                    for (int k = 0; k < habitaciones.size(); k++) {
                        if (listaReserva.get(i).getReservaHabitacion().get(j).getHabitacion().equals(habitaciones.get(k))) {
                            throw new Exception("Esa habitacion ya esta reservada");
                        }
                    }
                }
            }
        }


            //validar que la cantidad de personas sea igual o menor que la capacidad de las habitaciones elegidas
           int cantidadDisponible =0;
            for(int k=0; k<habitaciones.size();k++) {
                cantidadDisponible = cantidadDisponible+habitaciones.get(k).getCapacidad();
            }
            if(cantidadDisponible >= (cantidadPersonasMayores+cantidadPersonasMenores)){

            }

            //sumar el precio por dia de la habitación
            long diff = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
            precioHabitacion = precioHabitacion*diff;


        precioTotal = precioMayores + precioMenores + precioHabitacion;

        Reserva reservaGuardad = reservaRepo.save(reservaCliente);

        List<ReservaSilla> reservaSillas = new ArrayList<>();
        List<ReservaHabitacion> reservaHabitacions = new ArrayList<>();

        for(Silla silla: sillas){
            ReservaSilla rs = new ReservaSilla();
            rs.setReserva(reservaGuardad);
            rs.setSilla(silla);
            rs.setPrecio(silla.getPrecio());
            reservaSillaRepo.save(rs);
        }

        //Habitaciones
        for(Habitacion habitacion: habitaciones){
            ReservaHabitacion rh = new ReservaHabitacion();
            rh.setReserva(reservaGuardad);
            rh.setHabitacion(habitacion);
            rh.setPrecio(habitacion.getPrecio());
            reservaHabitacionRepo.save(rh);
        }

        return reservaGuardad;

    }

    @Override
    public List<Silla> generarListaReservaSilla(int cantidadPersonas, Reserva reserva, Vuelo vuelo) {

        List<Silla> sillas = new ArrayList<>();

        for (int i = 0; i < cantidadPersonas; i++) {
            sillas.add( crearReservaSilla(i, reserva, vuelo) );
        }

        return sillas;
    }



    @Override
    public Silla crearReservaSilla(int codigo, Reserva reserva, Vuelo vuelo) {

        boolean respuesta;
        Silla silla = null;

        do {
            int numero = 0;

            numero = (int) (Math.random() * vuelo.getCapacidad()); //dudas
            silla = obtenerSilla(vuelo, numero);

            respuesta = validarReservaSilla(reserva);

        } while (!respuesta);

        return silla;
    }

    @Override
    public Silla obtenerSilla(Vuelo vuelo, int codigoSilla) {
        Silla silla = sillaRepo.obtenerSilla(vuelo.getCodigo(),codigoSilla);
        return silla;
    }

    @Override
    public ReservaHabitacion crearReservaHabitacion(int codigo, Habitacion habitacion, Reserva reserva) {

        ReservaHabitacion reservaHabitacion = new ReservaHabitacion();

        reservaHabitacion.setCodigo(codigo);
        reservaHabitacion.setPrecio(habitacion.getPrecio());
        reservaHabitacion.setHabitacion(habitacion);
        reservaHabitacion.setReserva(reserva);

        return reservaHabitacionRepo.save(reservaHabitacion);
    }


    public boolean validarReservaSilla(Reserva reserva){

        List<Reserva> reservas = reservaRepo.listarReservas();
        List<ReservaSilla> reservaSillas = reservaSillaRepo.listarReservaSilla();

        boolean respuesta = false;

        for (int i = 0; i < reservas.size(); i++) {
            if(reserva.getFechaReserva()==reservas.get(i).getFechaReserva()){

                for (int j = 0; j < reserva.getReservaSilla().size(); j++) {

                    for (int k = 0; k < reservas.get(i).getReservaSilla().size(); k++) {

                        if(reserva.getReservaSilla().get(j).getSilla().equals(reservas.get(i).getReservaSilla().get(k).getSilla())){

                            respuesta = true;

                        }

                    }

                }

            }
        }

        return respuesta;
    }



}
