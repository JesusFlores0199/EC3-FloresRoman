package pe.edu.idat.EC3_FloresRoman.service;

import org.springframework.stereotype.Service;
import pe.edu.idat.EC3_FloresRoman.dto.DtoEntity;
import pe.edu.idat.EC3_FloresRoman.dto.FabricDto;
import pe.edu.idat.EC3_FloresRoman.dto.FabricRegisterDto;
import pe.edu.idat.EC3_FloresRoman.model.Fabric;
import pe.edu.idat.EC3_FloresRoman.repository.FabricRepository;
import pe.edu.idat.EC3_FloresRoman.repository.projection.FabricStockProjection;
import pe.edu.idat.EC3_FloresRoman.util.ConvertDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FabricService {
    private final FabricRepository fabricRepository;
    private final ConvertDto convertDto;

    public FabricService(FabricRepository fabricRepository, ConvertDto convertDto) {
        this.fabricRepository = fabricRepository;
        this.convertDto = convertDto;
    }

    public List<Fabric> obtenerTelas(){
        return fabricRepository.obtenerTelasSQL();
    }

    public List<DtoEntity> obtenerFabricDto(){
        List<DtoEntity> fabricDtoList = new ArrayList<>();
        fabricDtoList = fabricRepository.obtenerTelasSQL()
                .stream()
                .map(p -> convertDto.convertirADto(p, new FabricDto()))
                .collect(Collectors.toList());
        if (fabricDtoList.isEmpty())
            return null;
        return fabricDtoList;
    }

    public List<FabricStockProjection> obtenerTodasLasTelas(Integer unitsInStock){
        return fabricRepository.obtenerTodaslasTelas(unitsInStock);
    }

    public void registrarFabric(FabricRegisterDto fabricRegisterDto){
        try{
            fabricRepository.registrarTelas(
                    fabricRegisterDto.getFabricName(), fabricRegisterDto.getSupplierId(),
                    fabricRegisterDto.getCategoryId(), fabricRegisterDto.getUnitPrice());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarFabric(FabricRegisterDto fabricRegisterDto){
        try{
            fabricRepository.actualizarTelas(fabricRegisterDto.getFabricId(),
                    fabricRegisterDto.getFabricName(), fabricRegisterDto.getCategoryId(),
                    fabricRegisterDto.getCategoryId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
