package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vuelo implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    @ToString.Include
    private Integer codigo;

    @Column(length = 1, nullable = false)
    @ToString.Include
    private Integer estado;

    @Column(length = 50, nullable = false)
    @ToString.Include
    private String aerolinea;

    @Column(length = 3, nullable = false)
    private Integer capacidad;

    @OneToMany (mappedBy = "vuelo")
    @ToString.Exclude
    private List<Silla> silla;

    @ManyToOne
    private Ciudad ciudadDestino;

    @ManyToOne
    private Ciudad ciudadOrigen;

    public Vuelo(int codigo, int estado, String aerolinea, int capacidad) {
        this.codigo = codigo;
        this.estado = estado;
        this.aerolinea = aerolinea;
        this.capacidad = capacidad;

    }
}
