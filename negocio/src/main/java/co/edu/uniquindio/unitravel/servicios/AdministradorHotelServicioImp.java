package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.AdministradorHotelRepo;
import co.edu.uniquindio.unitravel.repositorios.HabitacionRepo;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorHotelServicioImp implements AdministradorHotelServicio {

    //Inicializacion de los repositorios necesarios.
    private AdministradorHotelRepo administradorHotelRepo;
    private HotelRepo hotelRepo;
    private HabitacionRepo habitacionRepo;

    //Constructor repositorios.
    public AdministradorHotelServicioImp(AdministradorHotelRepo administradorHotelRepo,
                                          HotelRepo hotelRepo, HabitacionRepo habitacionRepo){
        this.administradorHotelRepo = administradorHotelRepo;
        this.hotelRepo = hotelRepo;
        this.habitacionRepo = habitacionRepo;
    }

    @Override
    public AdministradorHotel obtenerAdminHotel(String codigo) throws Exception {
        return administradorHotelRepo.findById(codigo).orElse(null);
    }

    //Gestionar Hoteles.
    @Override
    public Hotel obtenerHotel(String nombre) throws Exception {
        return hotelRepo.findByNombre(nombre).orElse(null);
    }

    @Override
    public Hotel crearHotel(Hotel hotel) throws Exception {
        Hotel hotelEncontrado = obtenerHotel(hotel.getNombre());
        if (hotelEncontrado != null) {
            throw new Exception("Ya existe el hotel");
        }
        return hotelRepo.save(hotel);
    }

    @Override
    public Hotel modificarHotel(Hotel hotel) throws Exception {
        return null;
    }

    @Override
    public List<Hotel> listarHoteles() {
        return hotelRepo.findAll();
    }

    @Override
    public void eliminarHotel(String nombre) throws Exception {
        Hotel hotelEncontrado = obtenerHotel(nombre);

        if (hotelEncontrado == null) {
            throw new Exception("El hotel no existe");
        }
        hotelRepo.delete(hotelEncontrado);
    }


    //Gestionar Habitaciones.
    @Override
    public Habitacion crearHabitacion(Habitacion habitacion) throws Exception {
        Habitacion habitacionEncontrada = obtenerHabitacion(habitacion.getNumero());
        if(habitacionEncontrada != null) {
            throw new Exception("Ya existe una habitación con ese número");
        }
        return habitacionRepo.save(habitacion);
    }

    public Habitacion obtenerHabitacion(int numero) throws Exception {
        return habitacionRepo.findByNumero(numero).orElse(null);
    }

  }



