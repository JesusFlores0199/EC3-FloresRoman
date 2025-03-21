package pe.edu.idat.EC3_FloresRoman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.EC3_FloresRoman.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {Usuario findByNomusuario(String nomusuario);
}