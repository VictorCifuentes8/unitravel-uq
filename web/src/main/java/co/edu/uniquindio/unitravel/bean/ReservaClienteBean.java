package co.edu.uniquindio.unitravel.bean;


import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class ReservaClienteBean implements Serializable {

    @Autowired
    private ClienteServicio clienteServicio;

    @Getter @Setter
    private List<Reserva> reservas;

    @Value(value = "#{seguridadBean.persona}")
    private Persona personaSesion;

    @Getter @Setter
    private Reserva reserva;
    @Getter @Setter
    private Hotel hotel;


    @Getter @Setter
    private List<Habitacion> habitaciones;



    @PostConstruct
    public void init() {
        habitaciones = new ArrayList<>();
        reservas = clienteServicio.listarReservas(personaSesion.getCedula());
    }

    public void crearReserva(){

    }


}
