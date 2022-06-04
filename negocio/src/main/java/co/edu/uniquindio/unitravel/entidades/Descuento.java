package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Descuento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    private Integer codigo;

    @Column(length = 20)
    private String estado;

    @Column(length = 15)
    private double valorDescontar;

    @OneToOne
    private Reserva reserva;

    @OneToMany(mappedBy = "descuento")
    private List<CategoriaDescuento> categoriaDescuentos;

    public Descuento(int codigo, String estado, double valorDescontar) {
        this.codigo = codigo;
        this.estado = estado;
        this.valorDescontar = valorDescontar;
    }
}
