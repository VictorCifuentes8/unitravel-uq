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
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad implements Serializable {

    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PositiveOrZero
    @Column(length = 4)
    private Integer codigo;

    @ToString.Include
    @Column(length = 50, nullable = false)
    @Size(max = 50, message = "El nombre debe tener minimo 1 y maximo 50 caracteres"
            , min = 1)
    @NotBlank(message = "Por favor escriba el nombre de la ciudad")
    private String nombre;


    @Size(max = 300, message = "El nombre debe tener minimo 1 y maximo 50 caracteres"
            , min = 1)
    @NotBlank(message = "Por favor escriba el enlace de la imagen de la ciudad")
    @Column(nullable = false, length = 300)
    private String urlImagen;


    @OneToMany (mappedBy = "ciudad")
    @ToString.Exclude
    private List<Cliente> clientes;

    @OneToMany (mappedBy = "ciudadDestino")
    @ToString.Exclude
    private List<Vuelo> vuelosDestino;

    @OneToMany (mappedBy = "ciudadOrigen")
    @ToString.Exclude
    private List<Vuelo> vuelosOrigen;

    @OneToMany (mappedBy = "ciudad")
    @ToString.Exclude
    private List<Hotel> hoteles;

    public Ciudad(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
