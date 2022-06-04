package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Trabajador extends Persona implements Serializable {


    @ManyToOne
    private Categoria categoria;

    public Trabajador(String cedula, String nombre, @Positive int edad, @Email String email, String password) {
        super(cedula, nombre, edad, email, password);
    }

    public Trabajador() {

    }
}
