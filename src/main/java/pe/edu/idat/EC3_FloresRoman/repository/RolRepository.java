package pe.edu.idat.EC3_FloresRoman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.EC3_FloresRoman.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {Rol findByNomrol(String nomrol);
}