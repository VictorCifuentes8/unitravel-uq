package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AdministradorHotel extends Trabajador implements Serializable {

    @OneToMany (mappedBy = "administradorHotel", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Hotel> hoteles;

    public AdministradorHotel(String cedula, String nombre, int edad, String email, String password) {
        super(cedula, nombre, edad, email, password);
    }
}
