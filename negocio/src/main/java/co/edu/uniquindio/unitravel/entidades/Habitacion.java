package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Entity
@Setter
@Getter
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Habitacion implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    @Min(1)
    private Integer codigo;


    @PositiveOrZero
    @Column(length = 4)
    @Min(1)
    private Integer numero;

    @ToString.Include
    @Column(length = 9, nullable = false)
    @PositiveOrZero
    private double precio;

    @ToString.Include
    @Column(length = 2, nullable = false)
    @Min(1)
    private Integer capacidad;

    @ManyToOne
    private Hotel hotel;

    @ManyToMany
    @ToString.Exclude
    private List<Caracteristica> caracteristica;

    @ManyToMany (mappedBy = "habitacion")
    @ToString.Exclude
    private List<Cama> cama;

    @OneToMany (mappedBy = "habitacion")
    @ToString.Exclude
    private List<ReservaHabitacion> reservaHabitacion;

    @ElementCollection
    private List<String>fotosHabitacion;

    public Habitacion(Integer numero, double precio, int capacidad) {
        this.numero = numero;
        this.precio = precio;
        this.capacidad = capacidad;
    }

    public String getImagenPrincipal(){
        if(fotosHabitacion != null){
            if(!fotosHabitacion.isEmpty()){
                return fotosHabitacion.get(0);
            }
        }
        return "habitacion_principal.png";
    }

    public String formatearDinero(){
        Locale locale = new Locale("es", "CO");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(precio);
    }
}
