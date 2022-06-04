package co.edu.uniquindio.unitravel.converter;

import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class CamaConverter  implements Converter<Cama>, Serializable {

        @Autowired
        private UnitravelServicio unitravelServicio;

        @Override
        public Cama getAsObject(FacesContext context, UIComponent component, String value) {

            try {
                Cama cama = unitravelServicio.obtenerCama(Integer.parseInt(value));
                return cama;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }


    @Override
    public String getAsString(FacesContext context, UIComponent component, Cama value) {
        if(value!=null){
            return ""+value.getCodigo();
        }
        return "";
    }
}
