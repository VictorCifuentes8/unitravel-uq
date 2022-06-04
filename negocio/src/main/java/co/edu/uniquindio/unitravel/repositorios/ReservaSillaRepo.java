package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.ReservaSilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaSillaRepo extends JpaRepository<ReservaSilla, Integer> {

    @Query("select rs from ReservaSilla rs")
    List<ReservaSilla> listarReservaSilla();

}
