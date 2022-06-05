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
public class Caracteristica implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    @PositiveOrZero
    private Integer codigo;

    @Size(max = 2, message = "El nombre debe tener minimo 1 y maximo 2 caracteres: 1 Caracteristica de Hotel, " +
            "2:Caracteristica de Habitación"
            , min = 1)
    @NotBlank(message = "Por favor escriba el tipo")
    @Column(nullable = false, length = 2)
    private String tipo;

    @Size(max = 50, message = "El nombre debe tener minimo 1 y maximo 50 caracteres"
            , min = 1)
    @NotBlank(message = "Por favor escriba el nombre de la caracteristica")
    @Column(nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "caracteristica")
    @ToString.Exclude
    private List<Hotel> hotel;

    @ManyToMany(mappedBy = "caracteristica")
    @ToString.Exclude
    private List<Habitacion> habitacion;
}
