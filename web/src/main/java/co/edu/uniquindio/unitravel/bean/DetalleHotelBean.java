package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
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
public class DetalleHotelBean implements Serializable {



    @Value("#{param['hotelId']}")
    private String codigoHotel;

    @Getter
    @Setter
    private Hotel hotel;

    @Autowired
    private  UnitravelServicio unitravelServicio;

    @Autowired
    private ClienteServicio clienteServicio;


    @Getter
    @Setter
    private Comentario comentario;

    @Getter
    @Setter
    private List<Comentario> comentarios;


    @PostConstruct
    public void inicializar(){
        comentario = new Comentario();
        comentarios = new ArrayList<>();

         if(codigoHotel !=null && !codigoHotel.isEmpty()){
             try {
                 hotel = unitravelServicio.obtenerHotelCodigo(Integer.parseInt(codigoHotel));
                 comentarios = hotel.getComentario();
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
     }

    public void crearComentario(){
        try{
            comentario.setCliente(clienteServicio.obtenerCliente("10101010"));
            comentario.setHotel(hotel);
            unitravelServicio.crearComentario(comentario);
            comentarios.add(comentario);
            comentario = new Comentario();
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
