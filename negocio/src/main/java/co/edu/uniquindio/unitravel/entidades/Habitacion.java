package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Habitacion implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    private Integer codigo;


    @Column(length = 4)
    private Integer numero;

    @ToString.Include
    @Column(length = 9, nullable = false)
    private double precio;

    @ToString.Include
    @Column(length = 1, nullable = false)
    private Integer capacidad;

    @ManyToOne
    private Hotel hotel;

    @ManyToMany
    @ToString.Exclude
    private List<Caracteristica> caracteristica;

    @ManyToMany (mappedBy = "habitacion")
    @ToString.Exclude
    private List<Cama> cama;

    @OneToMany (mappedBy = "habitacion")
    @ToString.Exclude
    private List<ReservaHabitacion> reservaHabitacion;

    @ElementCollection
    private List<String>fotosHabitacion;

    public Habitacion(Integer numero, double precio, int capacidad) {
        this.numero = numero;
        this.precio = precio;
        this.capacidad = capacidad;
    }
}
