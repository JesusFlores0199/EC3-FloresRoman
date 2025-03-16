package pe.edu.idat.EC3_FloresRoman.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.idat.EC3_FloresRoman.model.Country;
import pe.edu.idat.EC3_FloresRoman.repository.CountryRepository;
import java.util.List;
import java.util.Optional;
@Service
public class CountryService {
    private final CountryRepository countryRepository;
    public CountryService(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    public List<Country> listarCountry(){
        return countryRepository.findAll();
    }
    public Country guardarCountry(Country country){
        return countryRepository.save(country);
    }
    public Optional<Country> obtenerCountryXid(String Code)
    {return countryRepository.findById(Code);}
}