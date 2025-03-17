package pe.edu.idat.EC3_FloresRoman.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.edu.idat.EC3_FloresRoman.dto.DtoEntity;

@Component
public class ConvertDto {

    public DtoEntity convertirADto(Object object,
                                   DtoEntity dto){
        return new ModelMapper().map(object, dto.getClass());
    }
}
