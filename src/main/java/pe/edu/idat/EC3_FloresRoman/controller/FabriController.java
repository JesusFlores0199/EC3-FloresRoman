package pe.edu.idat.EC3_FloresRoman.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.EC3_FloresRoman.dto.DtoEntity;
import pe.edu.idat.EC3_FloresRoman.dto.FabricRegisterDto;
import pe.edu.idat.EC3_FloresRoman.dto.GenericAnswer;
import pe.edu.idat.EC3_FloresRoman.repository.projection.FabricStockProjection;
import pe.edu.idat.EC3_FloresRoman.service.FabricService;
import pe.edu.idat.EC3_FloresRoman.service.SupplierService;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/fabric")
public class FabriController {
    private final FabricService fabricService;
    public FabriController(FabricService fabricService) {
        this.fabricService = fabricService;
    }

    @GetMapping
    public ResponseEntity<GenericAnswer<List<DtoEntity>>>
    obtenerProductos(){
        List<DtoEntity> fabricDtoList =
                fabricService.obtenerFabricDto();
        GenericAnswer<List<DtoEntity>> response
                = new GenericAnswer<>();
        response.setCorrecto(true);
        response.setMensaje("Lista de telas");
        response.setRespuesta(fabricDtoList);
        return new ResponseEntity<>(response,
                HttpStatus.OK);
    }


    @GetMapping("/unit-stock")
    public ResponseEntity<GenericAnswer<List<FabricStockProjection>>>
    obtenerTelasxStock(@RequestParam Integer stock){
        List<FabricStockProjection> fabricDtoList =
                fabricService.obtenerTodasLasTelas(stock);
        GenericAnswer<List<FabricStockProjection>>
                response = new GenericAnswer<>();
        response.setCorrecto(true);
        response.setMensaje("Lista de telas por stock");
        response.setRespuesta(fabricDtoList);
        return new ResponseEntity<>(response,
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericAnswer<String>>
    registrarTelas(@RequestBody FabricRegisterDto fabricRegisterDto){
        GenericAnswer<String> response = new GenericAnswer<>();
        try{
            fabricService.registrarFabric(fabricRegisterDto);
            response.setCorrecto(true);
            response.setMensaje("Tela registrada");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.setCorrecto(false);
            response.setMensajeError(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping
    public ResponseEntity<GenericAnswer<String>>
    actualizarTelas(@RequestBody FabricRegisterDto fabricRegisterDto){
        GenericAnswer<String> response = new GenericAnswer<>();
        try{
            fabricService.actualizarFabric(fabricRegisterDto);
            response.setCorrecto(true);
            response.setMensaje("Tela actualizada exitosamente");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.setCorrecto(false);
            response.setMensajeError(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
