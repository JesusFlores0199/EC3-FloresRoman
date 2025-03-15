package pe.edu.idat.EC3_FloresRoman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.EC3_FloresRoman.model.City;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    //select * from City where Name = :Name
    City findbyName(String Name);

}
