package pe.edu.idat.EC3_FloresRoman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.EC3_FloresRoman.model.Country;

public interface CountryRepository extends JpaRepository<Country,String> {
}
