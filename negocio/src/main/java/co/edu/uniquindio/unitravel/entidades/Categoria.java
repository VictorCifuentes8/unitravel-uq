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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    private Integer codigo;

    @Column(length = 20)
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
