package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Setter
@Getter
public class InicioBean implements Serializable {

    @Setter
    @Getter
    private List<Hotel> hoteles;

    @Setter
    @Getter
    private List<Habitacion> habitaciones;

    @Setter
    @Getter
    private List<Ciudad> ciudades;

    @Autowired
    private ClienteServicio clienteServicio;

    @PostConstruct
    public void inicializar(){
        hoteles = clienteServicio.listarHoteles();
        habitaciones = clienteServicio.listarHabitaciones();
        ciudades = clienteServicio.listarCiudades();
    }

    public String irRegistro(){
        return "registrarCliente?faces-redirect=true";

    }

    public String irDetalleHotel(String codigoHotel){
        return "detalleHotel?faces-redirect=true&amp;hotelId=" + codigoHotel;

    }
}

