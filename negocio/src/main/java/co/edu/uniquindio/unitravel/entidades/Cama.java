package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cama implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(length = 4)
    private Integer codigo;

    @PositiveOrZero
    @Column(length = 2, nullable = false)
    @Min(1)
    private Integer tipo;

    @Size(max = 20, message = "El nombre debe tener minimo 1 y maximo 20 caracteres"
            , min = 1)
    @NotBlank(message = "Por favor escriba el nombre de la cama")
    @Column(length =20, nullable = false)
    private String nombre;

    @ManyToMany
    @ToString.Exclude
    private List<Habitacion> habitacion;
}
