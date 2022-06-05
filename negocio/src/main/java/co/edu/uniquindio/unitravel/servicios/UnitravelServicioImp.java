package co.edu.uniquindio.unitravel.servicios;


import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UnitravelServicioImp implements UnitravelServicio {


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
                                CaracteristicaRepo caracteristicaRepo, ClienteRepo clienteRepo) {

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
    public Persona validarLogin(String email, String password) throws Exception {
        try {
            StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();
            Persona usuario = clienteRepo.findByEmail(email).orElse(null);
            if (usuario == null) {
                usuario = administradorHotelRepo.findByEmail(email).orElse(null);
            } else {
                if (!strongPasswordEncryptor.checkPassword(password, usuario.getPassword())) {
                    throw new Exception("La contraseña es incorrecta.");
                } else {
                    return usuario;
                }
            }

            if (usuario == null) {
                usuario = administradorRepo.findByEmail(email).orElse(null);
            } else {
                if (!strongPasswordEncryptor.checkPassword(password, usuario.getPassword())) {
                    throw new Exception("La contraseña es incorrecta.");
                } else {
                    return usuario;
                }

            }
            if (usuario == null) {
                throw new Exception("Los datos de autenticación son incorrectos.");
            } else {
                if (!strongPasswordEncryptor.checkPassword(password, usuario.getPassword())) {
                    throw new Exception("La contraseña es incorrecta.");
                } else {
                    return usuario;
                }
            }
            }catch (EncryptionOperationNotPossibleException e){
                throw new Exception("La contraseña es incorrecta.");
            }

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
    public Hotel obtenerHotelCodigo(Integer codigoHotel) throws Exception {
        return hotelRepo.findById(codigoHotel).orElseThrow(() -> new Exception("Hotel no encontrado"));
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
