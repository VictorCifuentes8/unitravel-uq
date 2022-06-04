package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CategoriaDescuento implements Serializable {

    @Column(length = 1)
    private boolean estado;

    @Id
    @ManyToOne
    private Categoria categoria;

    @Id
    @ManyToOne
    private Descuento descuento;

}
