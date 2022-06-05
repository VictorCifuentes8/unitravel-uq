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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PositiveOrZero
    @Column(length = 4)
    private Integer codigo;


    @Column(length = 20)
    @Size(max = 20, message = "El nombre debe tener minimo 1 y maximo 20 caracteres"
            , min = 1)
    @NotBlank(message = "Por favor escriba el tipo de categoria")
    private String tipo;

    @OneToMany
    private List<Administrador> administradores;

    @OneToMany(mappedBy = "categoria")
    private List<CategoriaDescuento> categoriaDescuentos;

    public Categoria(int codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }
}
