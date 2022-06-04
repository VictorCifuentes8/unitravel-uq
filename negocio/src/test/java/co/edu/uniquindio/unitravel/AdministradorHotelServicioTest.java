package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class AdministradorHotelServicioTest {

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    @Autowired
    private UnitravelServicio unitravelServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void loguearAdmnistradorHotel() {

        try {
            AdministradorHotel administradorHotelLogueado =
                    unitravelServicio.loginAdministradorHotel("laura@gmail.com", "4567");
            //Assertions.assertNull(administradorHotelLogueado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearHotel() throws Exception {

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarHotel() {

    }
}
