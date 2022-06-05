package co.edu.uniquindio.unitravel.entidades;

import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @Min(1) @Max(1000)
    private Integer codigo;


    @Column(nullable = false)
    @ToString.Include
    @Size(max = 50, message = "El nombre debe tener minimo 1 y maximo 50 caracteres"
            , min = 1)
    @NotBlank(message = "Por favor escriba el nombre de la ciudad")
    private String comentario;


    @ToString.Include
    @PositiveOrZero
    @Column(length = 1)
    @Max(5)
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
