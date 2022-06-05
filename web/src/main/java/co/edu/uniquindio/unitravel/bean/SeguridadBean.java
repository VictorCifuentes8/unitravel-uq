package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Persona;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
@Component
@Scope("session")
public class SeguridadBean implements Serializable {
    @Getter @Setter
    private Persona persona;
    @Getter @Setter
    private String correo;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private boolean autenticado;
    @Autowired
    private UnitravelServicio unitravelServicio;

    @Getter @Setter
    private int rol;
    public String iniciarSesion(){
        try {

            persona = unitravelServicio.validarLogin(correo,password);
            autenticado = true;
            if(persona instanceof Cliente){
                rol=1;
            }if (persona instanceof AdministradorHotel){
                rol=2;
            }
            if (persona instanceof Administrador){
                rol=3;
            }

            return "/index?faces-redirect=true";
        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("login-bean", msj);
        }
        return null;
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }
}

