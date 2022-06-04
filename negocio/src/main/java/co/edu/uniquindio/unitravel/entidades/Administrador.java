package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrador extends Trabajador implements Serializable {


    public Administrador(String cedula, String nombre, int edad, String email, String password) {
        super(cedula, nombre, edad, email, password);
    }

    public Administrador() {
        super();
    }
}
