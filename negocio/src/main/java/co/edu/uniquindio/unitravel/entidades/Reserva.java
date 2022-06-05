package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Reserva implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    @ToString.Include
    @PositiveOrZero
    private Integer codigo;

    @Future
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @ToString.Include
    private LocalDateTime fechaReserva;

    @Future
    @Column(nullable = false)
    @ToString.Include
    private LocalDateTime fechaInicio;

    @Future
    @Column(nullable = false)
    @ToString.Include
    private LocalDateTime fechaFin;

    @EqualsAndHashCode.Include
    @Column(length = 9, nullable = false)
    private double precioTotal;

    @EqualsAndHashCode.Include
    @Column(length = 2, nullable = false)
    private int estado;

    @EqualsAndHashCode.Include
    @Column(length = 2, nullable = false)
    @Min(1) @Max(99)
    private int cantidadPersonasMayores;

    @EqualsAndHashCode.Include
    @Column(length = 2, nullable = false)
    @Min(1) @Max(99)
    private int cantidadPersonasMenores;

    @EqualsAndHashCode.Include
    @ManyToOne
    private Cliente cliente;

    @OneToMany (mappedBy = "reserva")
    @ToString.Exclude
    private List<ReservaSilla> reservaSilla;

    @OneToMany (mappedBy = "reserva")
    @ToString.Exclude
    private List<ReservaHabitacion> reservaHabitacion;

    @OneToOne(mappedBy = "reserva")
    @ToString.Exclude
    private Descuento descuento;

    public Reserva(int codigo, LocalDateTime fechaReserva, LocalDateTime fechaInicio, LocalDateTime fechaFin, double precioTotal, int estado, int cantidadPersonasMayores, int cantidadPersonasMenores, Cliente cliente) {
        this.codigo = codigo;
        this.fechaReserva = fechaReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioTotal = precioTotal;
        this.estado = estado;
        this.cantidadPersonasMayores = cantidadPersonasMayores;
        this.cantidadPersonasMenores = cantidadPersonasMenores;
        this.cliente = cliente;
    }
}
