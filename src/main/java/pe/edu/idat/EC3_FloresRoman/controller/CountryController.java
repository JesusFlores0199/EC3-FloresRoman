package pe.edu.idat.EC3_FloresRoman.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.EC3_FloresRoman.service.CountryService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Country")
public class CountryController {
    private final CountryService countryService;
    public CountryController(CountryService countryService) {this.countryService = countryService;}

    @GetMapping
    public ResponseEntity<GenericResponseDto<List<???>>>
    obtenerPais(){
        List<??> countryDtoList =
                countryService.obtenerPaisesDto();
        GenericResponseDto<List<???>> response
                = new GenericResponseDto<>();
        response.setCorrecto(true);
        response.setMensaje("Lista de paises");
        response.setRespuesta(countryDtoList);
        return new ResponseEntity<>(response,
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericResponseDto<String>>
    registrarPaises(@RequestBody CountryRegisterDto countryRegisterDto){
        GenericResponseDto<String> response = new GenericResponseDto<>();
        try{
            countryService.registrarPaises(countryRegisterDto);
            response.setCorrecto(true);
            response.setMensaje("Pais registrado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.setCorrecto(false);
            response.setMensajeError(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping
    public ResponseEntity<GenericResponseDto<String>>
    actualizarPaises(@RequestBody CountryRegisterDto countryRegisterDto){
        GenericResponseDto<String> response = new GenericResponseDto<>();
        try{
            countryService.actualizarPaises(countryRegisterDto);
            response.setCorrecto(true);
            response.setMensaje("Pais actualizado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.setCorrecto(false);
            response.setMensajeError(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}