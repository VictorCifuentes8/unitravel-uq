package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class HotelBean implements Serializable {

    @Autowired
    private AdministradorHotelServicio hotelServicio;

    @Autowired
    private UnitravelServicio unitravelServicio;

    @Getter
    @Setter
    private Hotel hotel;

    @Getter
    @Setter
    private List<Ciudad> ciudades;

    @Getter
    @Setter
    private List<Caracteristica> caracteristicasHotel;

    @Getter
    @Setter
    private List<Caracteristica> caracteristicasHabitacion;

    @Value(value = "#{seguridadBean.persona}")
    private Persona personaSesion;
    @Getter
    @Setter
    private List<Cama> camas;

    @Getter
    @Setter
    private List<AdministradorHotel> administradoresHotel;

    @Value("${upload.url}")
    private String urlImagenes;

    private ArrayList<String> imagenes;

    private ArrayList<Habitacion> habitaciones;

    private ArrayList<String> imagenesHabitacion;

    @Getter
    @Setter
    private Habitacion habitacion;


    //Constructor del objeto hotel con postConstruct
    @PostConstruct
    public void init(){
        hotel = new Hotel();
        this.habitaciones = new ArrayList();
        this.imagenes = new ArrayList<>();
        this.imagenesHabitacion = new ArrayList();
        this.habitacion = new Habitacion();
        ciudades = unitravelServicio.listarCiudades();
        administradoresHotel = unitravelServicio.listarAdminsHotel();
        caracteristicasHotel = unitravelServicio.listarCaracteristicasHotel();
        caracteristicasHabitacion = unitravelServicio.listarCaracteristicasHabitacion();
        camas = unitravelServicio.listarCamas();
    }

    public void subirImagenes(FileUploadEvent event) {
        UploadedFile imagen = event.getFile();
        String nombreImagen = subirImagen(imagen);
        if(nombreImagen!=null) {
            imagenes.add(nombreImagen);
        }
    }


    public void subirImagenesHabitacion(FileUploadEvent event) {
        UploadedFile imagen = event.getFile();
        String nombreImagen = subirImagen(imagen);
        if(nombreImagen!=null) {
            imagenesHabitacion.add(nombreImagen);
        }
    }

    public String subirImagen(UploadedFile imagen){
        try {
            File archivo = new File(urlImagenes + "/" + imagen.getFileName());
            OutputStream outputStream = new FileOutputStream(archivo);
            IOUtils.copy(imagen.getInputStream(),outputStream);
            return imagen.getFileName();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public String crearHotel(){
        try {

            if(imagenes.size()>0) {

            if(habitaciones.size() > 0) {

                hotel.setFotosHotel(imagenes);
                hotel.setAdministradorHotel((AdministradorHotel) personaSesion);

                Hotel hotelCreado = hotelServicio.crearHotel(hotel);
                habitaciones.forEach(h -> {
                    try {
                        h.setHotel(hotelCreado);
                        hotelServicio.crearHabitacion(h);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta de Registro",
                        "El Registro se realizo con exito");
                FacesContext.getCurrentInstance().addMessage("mensajeBean",mensaje);

            }else {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta",
                        "Es necesario asignar habitaciones al hotel");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
            }else {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta",
                        "Es obligatorio subir Imagenes al hotel");
                FacesContext.getCurrentInstance().addMessage(null,mensaje);
            }

        }catch (Exception e){
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "No se ha podido crear el hotel",
                    e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,mensaje);
        }
        return null;
    }

    public void crearHabitacion(){
        try {
            if(imagenesHabitacion.size()>0) {
                habitacion.setFotosHabitacion(imagenesHabitacion);
                habitaciones.add(habitacion);
                habitacion = new Habitacion();
                imagenesHabitacion = new ArrayList<>();

                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta de Registro",
                        "La habitación se creo con exito");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }else{
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta",
                        "Es obligatorio subir Imagenes a la habitación");
                FacesContext.getCurrentInstance().addMessage(null,mensaje);
            }
        }catch (Exception e){
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "No se ha podido crear la habitación",
                    e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,mensaje);
        }

    }
}
