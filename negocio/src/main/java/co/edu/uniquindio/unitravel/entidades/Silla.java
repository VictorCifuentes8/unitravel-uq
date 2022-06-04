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
public class Silla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    private Integer codigo;

    private Integer numero;

    @Column(length = 3, nullable = false, unique = true)
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
