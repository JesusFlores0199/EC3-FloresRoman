package pe.edu.idat.EC3_FloresRoman.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.EC3_FloresRoman.Exception.ResourceNotFoundException;
import pe.edu.idat.EC3_FloresRoman.model.Category;
import pe.edu.idat.EC3_FloresRoman.model.Suppliers;
import pe.edu.idat.EC3_FloresRoman.service.CategoryService;
import pe.edu.idat.EC3_FloresRoman.service.SupplierService;

import java.util.List;
@RestController
@RequestMapping("/api/v1/suppliers")
public class SuppliersCategory {
    private final SupplierService
            supplierService;

    public SuppliersCategory(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<Suppliers>> listarProovedores(){
        List<Suppliers> suppliersList
                = supplierService
                .listarProveedores();
        if(suppliersList.isEmpty()){
            return new ResponseEntity<>(
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(suppliersList,
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suppliers> obtenerProveedores(
            @PathVariable Integer id){
        Suppliers suppliers = supplierService
                .obtenerSuppliersXid(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "El proveedor buscado no existe"));
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Suppliers> registrarProveedores(
            @RequestBody Suppliers suppliers){
        return new ResponseEntity<>(
                supplierService.guardarProveedores(suppliers),
                HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Suppliers> actualizarProveedores(
            @PathVariable Integer id,
            @RequestBody Suppliers suppliers){
        Suppliers currentSuppliers = supplierService
                .obtenerSuppliersXid(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "El proveedor buscado no existe"));
        currentSuppliers.setCompanyname(suppliers.getCompanyname());
        currentSuppliers.setContactname(suppliers.getContactname());
        currentSuppliers.setContacttitle(suppliers.getContacttitle());
        currentSuppliers.setAddress(suppliers.getAddress());
        currentSuppliers.setCity(suppliers.getCity());
        currentSuppliers.setRegion(suppliers.getRegion());
        currentSuppliers.setPostalcode(suppliers.getPostalcode());
        currentSuppliers.setCountry(suppliers.getCountry());
        currentSuppliers.setPhone(suppliers.getPhone());
        currentSuppliers.setFax(suppliers.getFax());
        return new ResponseEntity<>(
                supplierService.guardarProveedores(currentSuppliers),
                HttpStatus.OK);
    }
}
