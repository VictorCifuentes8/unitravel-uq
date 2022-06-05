package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrador extends Trabajador implements Serializable {

    public Administrador() {
        super();
    }
}
