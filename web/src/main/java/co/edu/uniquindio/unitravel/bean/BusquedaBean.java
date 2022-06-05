package co.edu.uniquindio.unitravel.bean;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class BusquedaBean implements Serializable {

    @Getter
    @Setter
    private String busqueda;

    @Value("#{param['busqueda']}")
    private String busquedaParametro;

    @Autowired
    private ClienteServicio clienteServicio;

    @Getter
    @Setter
    private List<Hotel> hoteles;

    @PostConstruct
    public void init() {
        hoteles = new ArrayList<>();
            if (busquedaParametro != null && !busquedaParametro.isEmpty()) {
                hoteles = clienteServicio.buscarHotelesPorNombre(busquedaParametro);
            }
    }
    public String buscar(){
        return "resultadosBusquedaHoteles?faces-redirect=true&amp;busqueda=" +busqueda;
    }
}
