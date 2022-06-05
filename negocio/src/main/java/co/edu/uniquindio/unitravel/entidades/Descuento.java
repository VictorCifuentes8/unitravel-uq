package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @PositiveOrZero
    @Min(1)
    private Integer codigo;

    @Column(length = 20)
    @Size(max = 20, message = "El nombre debe tener minimo 1 y maximo 20 caracteres"
            , min = 1)
    @NotBlank(message = "Por favor escriba el estado")
    private String estado;


    @Column(length = 15)
    @PositiveOrZero
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
