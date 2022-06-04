package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Caracteristica implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    private Integer codigo;

    @Column(nullable = false, length = 2)
    private String tipo;

    @Column(nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "caracteristica")
    @ToString.Exclude
    private List<Hotel> hotel;

    @ManyToMany(mappedBy = "caracteristica")
    @ToString.Exclude
    private List<Habitacion> habitacion;
}
