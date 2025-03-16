package pe.edu.idat.EC3_FloresRoman.controller;


import org.codehaus.plexus.resource.loader.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.EC3_FloresRoman.model.Country;
import pe.edu.idat.EC3_FloresRoman.service.impl.CountryService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Country")
public class CountryController {
    private final CountryService countryService;
    public CountryController(CountryService countryService) {this.countryService = countryService;}

    @GetMapping
    public ResponseEntity<List<Country>> listarPaises(){
        List<Country> countryList
                = countryService
                .listarCountry();
        if(countryList.isEmpty()){
            return new ResponseEntity<>(
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(countryList,
                HttpStatus.OK);
    }
    @GetMapping("/{code}")
    public ResponseEntity<Country> obtenerPais(
            @PathVariable String Code) throws ResourceNotFoundException {
        Country country = countryService
                .obtenerCountryXid(Code)
                .orElseThrow(() -> new ResourceNotFoundException("Pais buscado no existe"));
        return new ResponseEntity<>(country, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Country> registrarPais(
            @RequestBody Country country){
        return new ResponseEntity<>(
                countryService.guardarCountry(country),
                HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Country> actualizarPais(
            @PathVariable String Code,
            @RequestBody Country country) throws ResourceNotFoundException {
        Country currentCountry = countryService
                .obtenerCountryXid(Code)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Pais buscado no existe"));
        currentCountry.setName(country.getName());
        currentCountry.setContinent(country.getContinent());
        currentCountry.setRegion(country.getRegion());
        currentCountry.setSurfaceArea(country.getSurfaceArea());
        currentCountry.setIndepYear(country.getIndepYear());
        currentCountry.setPopulation(country.getPopulation());
        currentCountry.setLifeExpectancy(country.getLifeExpectancy());
        currentCountry.setGNP(country.getGNP());
        currentCountry.setGNPOId(country.getGNPOId());
        currentCountry.setLocalName(country.getLocalName());
        currentCountry.setGovernmentForm(country.getGovernmentForm());
        currentCountry.setHeadOfState(country.getHeadOfState());
        currentCountry.setCapital(country.getCapital());
        currentCountry.setCode2(country.getCode2());
        return new ResponseEntity<>(
                countryService.guardarCountry(currentCountry),
                HttpStatus.OK);
    }

}