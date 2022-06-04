package co.edu.uniquindio.unitravel;

import ch.qos.logback.core.net.SyslogOutputStream;
import co.edu.uniquindio.unitravel.entidades.*;
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

@SpringBootTest
@Transactional
public class ClienteServicioTest {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private UnitravelServicio unitravelServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarClienteTest(){


        Cliente c = new Cliente("9435","Laura",22,"laura123@gmail.com","123456");
        List<String> telefonos = new ArrayList<>();
        telefonos.add("369852147");
        telefonos.add("896523698");
        c.setTelefonos(telefonos);


        try {
            Cliente clienteGuardado = clienteServicio.registrarCliente(c);
            Assertions.assertNotNull(clienteGuardado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarClienteTest() throws Exception {
        Cliente cliente = clienteServicio.obtenerCliente("9234");
        cliente.setPassword("123456");

        clienteServicio.actualizarCliente(cliente);

        try {
            Cliente actualizado = clienteServicio.actualizarCliente(cliente);
            Assertions.assertEquals("123456",actualizado.getPassword());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarClienteTest(){
        try{
            clienteServicio.eliminarCliente("8524");
            Cliente clienteEliminado = clienteServicio.obtenerCliente("8524");
            Assertions.assertNull(clienteEliminado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarClienteTest() {
        List<Cliente> listaClientes = clienteServicio.listarClientes();
        listaClientes.forEach(System.out::println);
        Assertions.assertEquals(1, listaClientes.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void loginClienteTest() {
        try{
            Cliente cliente = unitravelServicio.loginCliente("luisa@gmail.com","8521");
            Assertions.assertNotNull(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void recuperarContraseniaTest() throws Exception {
        Cliente cliente = clienteServicio.obtenerCliente("8524");
        try {
            String password = unitravelServicio.recuperarContrasenia(cliente.getEmail());
            Assertions.assertNotNull(password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @Test
    @Sql("classpath:dataset.sql")
    public void listarVuelosDestinoTest() throws Exception {
        List<Vuelo> listaVuelosDestino = clienteServicio.vuelosDestino("Armenia");
        listaVuelosDestino.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHotelesDestinoTest() throws Exception {
        List<Hotel> listaHotelesDestino = clienteServicio.buscarHotelesPorDestino("Circasia");
        listaHotelesDestino.forEach(System.out::println);
    }


}