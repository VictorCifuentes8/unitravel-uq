package co.edu.uniquindio.unitravel.entidades.dto;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class hotelesCiudadDTO {

    private Ciudad ciudad;
    private long cantidadHotelesCiudad;
}
