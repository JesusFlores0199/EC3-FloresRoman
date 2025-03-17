package pe.edu.idat.EC3_FloresRoman.service;

import org.springframework.stereotype.Service;
import pe.edu.idat.EC3_FloresRoman.model.Suppliers;
import pe.edu.idat.EC3_FloresRoman.repository.SuppliersRepository;

import java.util.List;
import java.util.Optional;
@Service
public class SupplierService {
    private final SuppliersRepository
            suppliersRepository;
    public SupplierService(
            SuppliersRepository suppliersRepository) {
        this.suppliersRepository
                = suppliersRepository;
    }

    public List<Suppliers> listarProveedores(){
        return suppliersRepository.findAll();
    }
    public Suppliers guardarProveedores(
            Suppliers suppliers){
        return suppliersRepository
                .save(suppliers);
    }

    public Optional<Suppliers>
    obtenerSuppliersXid(Integer id){
        return suppliersRepository.findById(id);
    }
}
