package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class ClienteBean implements Serializable {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private UnitravelServicio unitravelServicio;

    @Getter
    @Setter
    private List<Ciudad> ciudades;

    @Getter
    @Setter
    private Cliente cliente;


    //Constructor del objeto cliente con postConstruct
    @PostConstruct
    public void init(){
        cliente = new Cliente();
        ciudades = unitravelServicio.listarCiudades();
    }

    public void registrarCliente(){
        try {

            clienteServicio.registrarCliente(cliente);
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta de Registro",
                    "El Registro se realizo con exito");
            FacesContext.getCurrentInstance().addMessage("mensajeBean",mensaje);


        }catch (Exception e){
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se realizo el registro",
                    e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensajeBean",mensaje);
        }

    }

}
