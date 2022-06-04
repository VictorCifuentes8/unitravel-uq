package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdministradorServicioImp implements AdministradorServicio {

    //Inicializacion de los repositorios necesarios.
    private AdministradorRepo administradorRepo;
    private CiudadRepo ciudadRepo;
    private VueloRepo vueloRepo;
    private AdministradorHotelRepo administradorHotelRepo;
    private SillaRepo sillaRepo;

    //Constructor repositorios.
    public AdministradorServicioImp(AdministradorRepo administradorRepo, CiudadRepo ciudadRepo,
                                    VueloRepo vueloRepo,AdministradorHotelRepo administradorHotelRepo){
        this.administradorRepo = administradorRepo;
        this.ciudadRepo = ciudadRepo;
        this.vueloRepo = vueloRepo;
        this.administradorHotelRepo = administradorHotelRepo;
    }

    @Override
    public Optional<Ciudad> obtenerCiudad(int codigo) {
        return administradorRepo.obtenerCiudadId(codigo);
    }


    @Override
    public Ciudad crearCiudad(int codigo, String nombreCiudad) throws Exception{
        Optional<Ciudad> ciudadOp = obtenerCiudad(codigo);
        if (ciudadOp.isPresent()) {
            throw new Exception("Ya existe la ciudad");
        }

        Ciudad ciudad = new Ciudad(codigo,nombreCiudad);

        return ciudadRepo.save(ciudad);
    }

    @Override
    public void eliminarCiudad(int codigoCiudad) throws Exception {
        Optional<Ciudad> ciudadOp = obtenerCiudad(codigoCiudad);

        if (ciudadOp.isEmpty()) {
            throw new Exception("La ciudad no existe");
        }
        ciudadRepo.delete(ciudadOp.get());
    }

    @Override
    public Optional<Vuelo> obtenerVuelo(int codigo) {
        return administradorRepo.obtenerVueloId(codigo);
    }

    @Override
    public Vuelo crearVuelo(int codigo, int estado, String aerolinea, int capacidad) throws Exception{

        Optional<Vuelo> vueloOp = obtenerVuelo(codigo);

        if (vueloOp.isPresent()) {
            throw new Exception("Ya existe el vuelo");
        }

        Vuelo vuelo = new Vuelo(codigo,estado,aerolinea,capacidad);

        List<Silla> sillas = new List<Silla>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Silla> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Silla silla) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Silla> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Silla> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Silla get(int index) {
                return null;
            }

            @Override
            public Silla set(int index, Silla element) {
                return null;
            }

            @Override
            public void add(int index, Silla element) {

            }

            @Override
            public Silla remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Silla> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Silla> listIterator(int index) {
                return null;
            }

            @Override
            public List<Silla> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        for (int i = 0; i < capacidad; i++) {

                Silla silla = new Silla();
                silla = crearSilla(i*10,i,50000,vuelo);
                sillas.add(silla);
        }

        vuelo.setSilla(sillas);

        return vueloRepo.save(vuelo);
    }

    @Override
    public void eliminarVuelo(int codigoVuelo) throws Exception{

        Optional<Vuelo> vueloOp = obtenerVuelo(codigoVuelo);

        if (vueloOp.isEmpty()) {
            throw new Exception("El vuelo no existe");
        }
        vueloRepo.delete(vueloOp.get());
    }

    @Override
    public Optional<AdministradorHotel> obtenerAdministradorHotel(String cedula) throws Exception{
        return administradorRepo.obtenerAdministradorHotelId(cedula);
    }

    @Override
    public AdministradorHotel crearAdministradorHotel(String cedula, String nombre, int edad, String email, String password)throws Exception{

        Optional<AdministradorHotel> administradorHotelOp = obtenerAdministradorHotel(cedula);

        if (administradorHotelOp.isPresent()) {
            throw new Exception("Ya existe el administrador de hotel");
        }

        AdministradorHotel administradorHotel = new AdministradorHotel(cedula,nombre,edad,email,password);

        return administradorHotelRepo.save(administradorHotel);

    }

    @Override
    public void eliminarAdministradorHotel(String cedula) {
        //eliminar de manera lógica
    }

    @Override
    public Silla crearSilla(int codigo, int posicion, double precio, Vuelo vuelo) {

        Silla silla = new Silla();

        silla.setCodigo(codigo);
        silla.setPosicion(posicion);
        silla.setPrecio(precio);
        silla.setVuelo(vuelo);

        return sillaRepo.save(silla);
    }

    @Override
    public boolean obtenerSilla(int codigo) {


        return false;
    }
}
