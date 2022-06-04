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
public class VuelosPorCiudadDTO {

    private Ciudad ciudadOrigen;
    private int codigoVuelo;
    private int estadoVuelo;
    private Ciudad ciudadDestino;
    private long numRegistros;

}
