package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Silla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PositiveOrZero
    @Column(length = 4)
    private Integer codigo;

    @Column(length = 3)
    @PositiveOrZero
    private Integer numero;

    @Column(length = 3, nullable = false, unique = true)
    @PositiveOrZero
    private Integer posicion;

    @Column(length = 9, nullable = false)
    private double precio;

    @OneToMany (mappedBy = "silla")
    @ToString.Exclude
    private List<ReservaSilla> reservaSilla;

    //@Id
    @ManyToOne
    private Vuelo vuelo;

    public Silla(int codigo, int posicion, double precio, Vuelo vuelo) {
        this.codigo = codigo;
        this.posicion = posicion;
        this.precio = precio;
        this.vuelo = vuelo;
    }
}
