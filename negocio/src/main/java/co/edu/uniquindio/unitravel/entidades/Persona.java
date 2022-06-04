package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 15)
    @Size(max = 15, message = "El codigo debe tener minimo 10 y maximo 15 caracteres"
            , min = 10)
    @NotBlank(message = "Por favor escriba su cedula")
    private String cedula;


    @Column(length = 50, nullable = false)
    @Size(max = 50, message = "El nombre debe tener minimo 1 y maximo 50 caracteres"
            , min = 1)
    @NotBlank(message = "Por favor escriba su nombre")
    private String nombre;

    @Positive
    @Column(length = 3, nullable = false)
    private Integer edad;

    @Email
    @Size(max = 50, message = "El correo debe tener minimo 20 y maximo 50 caracteres")
    @Column(length = 50, unique = true, nullable = false)
    @NotBlank(message = "Por favor escriba su email")
    private String email;

    @Column(length = 20, unique = true, nullable = false)
    @Size(max = 20, message = "La contraseña debe tener minimo 3 y maximo 20 caracteres"
            , min = 3)
    @NotBlank(message = "Por favor escriba su contraseña")
    private String password;

}
