package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import co.edu.uniquindio.unitravel.servicios.AdministradorServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootTest
@Transactional
public class AdministradorServicioTest {

    @Autowired
    private AdministradorServicio administradorServicio;

    @Autowired
    private CiudadRepo ciudadRepo;

    @Autowired
    private UnitravelServicio unitravelServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCiudad() throws Exception {

        Optional<Ciudad> ciudad = administradorServicio.obtenerCiudad(1);
        System.out.println(ciudad.get());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearCiudad() throws Exception {

        Ciudad ciudad = administradorServicio.crearCiudad(4,"Salento");
        System.out.println(ciudad);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCiudad(){

        try {
            administradorServicio.eliminarCiudad(1);
            Optional<Ciudad> ciudadEliminada = administradorServicio.obtenerCiudad(1);
            Assertions.assertNull(ciudadEliminada);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Test
    @Sql("classpath:dataset.sql")
    public void crearVuelo() throws Exception {

        Vuelo vuelo = administradorServicio.crearVuelo(123,1,"Avianca",25000);
        System.out.println(vuelo);

    }
}
