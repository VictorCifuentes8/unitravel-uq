package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hotel implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    @ToString.Include
    private Integer codigo;

    @Column(length = 40,nullable = false)
    @ToString.Include
    private String nombre;

    @Column(length = 100,nullable = false,unique = true)
    private String direccion;

    @Column(length = 15,nullable = false)
    private String telefono;

    @Column(length = 10)
    @ToString.Include
    private Integer numEstrellas;

    @Lob
    private String Descripcion;

    @ManyToOne
    @ToString.Include
    private Ciudad ciudad;

    @OneToMany (mappedBy = "hotel")
    @ToString.Exclude
    private List<Habitacion> habitaciones;

    @ManyToMany
    @ToString.Exclude
    private List<Caracteristica> caracteristica;

    @OneToMany (mappedBy = "hotel")
    @ToString.Exclude
    private List<Comentario> comentario;


    @ManyToOne
    private AdministradorHotel administradorHotel;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> fotosHotel;

    public Hotel(int codigo, String nombre, String direccion, String telefono, int numEstrellas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.numEstrellas = numEstrellas;
    }


    /*

     */
    public String getImagenPrincipal(){
        if(fotosHotel != null){
            if(!fotosHotel.isEmpty()){
                return fotosHotel.get(0);
            }
        }
        return "Hotel.png";
    }
}
