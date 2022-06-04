package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReservaSilla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    private Integer codigo;

    @Column(length = 10,nullable = false)
    private boolean tipo;

    @Positive
    @Column(length = 10,nullable = false)
    private double precio;

    @ManyToOne
    private Reserva reserva;

    @ManyToOne
    private Silla silla;

    public ReservaSilla(int codigo, boolean tipo, double precio, Reserva reserva, Silla silla) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.precio = precio;
        this.reserva = reserva;
        this.silla = silla;
    }
}
