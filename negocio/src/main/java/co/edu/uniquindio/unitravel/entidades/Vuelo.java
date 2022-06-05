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
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vuelo implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    @ToString.Include
    @Min(1)
    private Integer codigo;

    @Column(length = 1, nullable = false)
    @ToString.Include
    @Min(1)
    private Integer estado;

    @Column(length = 50, nullable = false)
    @ToString.Include
    @Size(max = 50, message = "El nombre debe tener minimo 1 y maximo 50 caracteres"
            , min = 1)
    @NotBlank(message = "Por favor escriba el nombre de la aerolinea")
    private String aerolinea;

    @Column(length = 3, nullable = false)
    @PositiveOrZero
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
