package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
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
    @Column(length = 4)
    private Integer codigo;

    @ToString.Include
    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(nullable = false)
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
