package co.edu.uniquindio.unitravel.entidades;

import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {


    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @Column(length = 4)
    private Integer codigo;

    @Column(nullable = false)
    @ToString.Include
    private String comentario;

    @Column(length = 1)
    @ToString.Include
    private Integer calificacion;

    @Column(nullable = false)
    private LocalDateTime fechaCalificacion;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Hotel hotel;

    public Comentario( String comentario, Integer calificacion, LocalDateTime fechaCalificacion, Hotel hotel, Cliente cliente) {
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.fechaCalificacion = fechaCalificacion;
        this.cliente = cliente;
        this.hotel = hotel;
    }

}
