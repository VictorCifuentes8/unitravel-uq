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
public class Cama implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(length = 4)
    private Integer codigo;

    @Column(length = 2, nullable = false)
    private Integer tipo;

    @Column(length =20, nullable = false)
    private String nombre;

    @ManyToMany
    @ToString.Exclude
    private List<Habitacion> habitacion;
}
