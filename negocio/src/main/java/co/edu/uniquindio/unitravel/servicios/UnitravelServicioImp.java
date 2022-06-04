package co.edu.uniquindio.unitravel.servicios;


import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UnitravelServicioImp implements UnitravelServicio{


    //Inicializacion de los repositorios necesarios.
    private AdministradorHotelRepo administradorHotelRepo;
    private AdministradorRepo administradorRepo;
    private HotelRepo hotelRepo;
    private HabitacionRepo habitacionRepo;
    private CiudadRepo ciudadRepo;
    private ClienteRepo clienteRepo;
    private CaracteristicaRepo caracteristicaRepo;
    private CamaRepo camaRepo;
    private ComentarioRepo comentarioRepo;

    //Constructor repositorios.
    public UnitravelServicioImp(AdministradorHotelRepo administradorHotelRepo,
                                AdministradorRepo administradorRepo,
                                CiudadRepo ciudadRepo, HotelRepo hotelRepo,
                                HabitacionRepo habitacionRepo, CamaRepo camaRepo,
                                ComentarioRepo comentarioRepo,
                                CaracteristicaRepo caracteristicaRepo){

        this.administradorHotelRepo = administradorHotelRepo;
        this.hotelRepo = hotelRepo;
        this.habitacionRepo = habitacionRepo;
        this.ciudadRepo = ciudadRepo;
        this.clienteRepo = clienteRepo;
        this.administradorRepo = administradorRepo;
        this.caracteristicaRepo = caracteristicaRepo;
        this.camaRepo = camaRepo;
        this.comentarioRepo = comentarioRepo;
    }


    @Override
    public Cliente loginCliente(String email, String password) throws Exception {
        Optional<Cliente> cliente = clienteRepo.findByEmailAndPassword(email, password);
        if(cliente.isEmpty()){
            throw new Exception("Los datos de autenticación son erroneos");
        }
        return cliente.get();
    }

    @Override
    public AdministradorHotel loginAdministradorHotel(String email, String password) throws Exception {
        Optional<AdministradorHotel> administradorHotel  =
                administradorHotelRepo.findByPasswordAndEmail(email, password);
        if(administradorHotel.isEmpty()){
            throw new Exception("Los datos de autenticación son erroneos");
        }
        return administradorHotel.get();
    }

    @Override
    public Administrador loguearAdministrador(String email, String password) throws Exception {

        Optional<Administrador> administradorOp = administradorRepo.findByPasswordAndEmail(password,email);

        if(administradorOp.isEmpty()){
            throw new Exception("Incorrecto ingreso de usuario y contraseña");
        }
        return administradorOp.get();
    }

    @Override
    public String recuperarContrasenia(String email) throws Exception {
        Optional<Cliente> cliente = clienteRepo.findByEmail(email);
        if(cliente.isEmpty()){
            throw new Exception("El Cliente no existe");
        }
        return cliente.get().getPassword();
    }

    @Override
    public String recuperarContraseniaAdminHotel(String email) throws Exception {
        Optional<AdministradorHotel> administradorHotel = administradorHotelRepo.findByEmail(email);
        if(administradorHotel.isEmpty()){
            throw new Exception("El Cliente no existe");
        }
        return administradorHotel.get().getPassword();
    }

    @Override
    public String recuperarContraseniaAdmin(String email) throws Exception {
        Optional<Administrador> administrador = administradorRepo.findByEmail(email);
        if(administrador.isEmpty()){
            throw new Exception("El Cliente no existe");
        }
        return administrador.get().getPassword();
    }


    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepo.findAll();
    }

    @Override
    public Ciudad obtenerCiudad(Integer codigo) throws Exception {
        return ciudadRepo.findById(codigo).orElse(null);
    }

    @Override
    public List<AdministradorHotel> listarAdminsHotel() {
        return administradorHotelRepo.findAll();
    }

    @Override
    public List<Caracteristica> listarCaracteristicasHabitacion() {
        return caracteristicaRepo.findAllByTipo("2");
    }

    @Override
    public List<Caracteristica> listarCaracteristicasHotel() {
        return caracteristicaRepo.findAllByTipo("1");
    }

    @Override
    public Caracteristica obtenerCaracteristica(Integer id) throws Exception {
        return caracteristicaRepo.findById(id).orElseThrow(()-> new Exception("El codigo no existe") ) ;
    }

    @Override
    public Cama obtenerCama(Integer codigo) throws Exception {
        return camaRepo.findById(codigo).orElseThrow(()-> new Exception("El codigo no existe") ) ;
    }

    @Override
    //Obtener un hotel por codigo
    public Hotel obtenerHotelCodigo(Integer codigo)throws Exception{
        return hotelRepo.findByCodigo(codigo).orElse(null);
    }

    @Override
    public void crearComentario(Comentario comentario) {
        comentario.setFechaCalificacion(LocalDateTime.now());
        comentarioRepo.save(comentario);
    }
    @Override
    public List<Cama> listarCamas() {
        return camaRepo.findAll();
    }
}
