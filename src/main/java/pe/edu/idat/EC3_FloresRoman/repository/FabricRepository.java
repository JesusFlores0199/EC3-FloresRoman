package pe.edu.idat.EC3_FloresRoman.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.idat.EC3_FloresRoman.model.Fabric;
import pe.edu.idat.EC3_FloresRoman.repository.projection.FabricStockProjection;

import java.util.List;

public interface FabricRepository extends JpaRepository<Fabric, Integer> {
    List<Fabric> findByDiscontinued(Boolean discontinued);
    @Query(value = "SELECT * FROM fabric WHERE discontinued=0",
            nativeQuery = true)
    List<Fabric> obtenerTelasSQL();

    @Query(value = "select p.FabricID, p.FabricName, p.UnitPrice, " +
            "c.CategoryName, s.CompanyName, p.UnitsInStock   from fabric p " +
            "inner join categories c on P.CategoryID = C.CategoryID " +
            "inner join suppliers s on P.SupplierID = S.SupplierID " +
            "where p.UnitsInStock <= :unitsInStock",
            nativeQuery = true)
    List<FabricStockProjection> obtenerTodaslasTelas(
            @Param("unitsInStock") Integer unitsInStock);

    @Modifying
    @Transactional
    @Query(value = "CALL RegistrarFabric(:fabricname, :supplierid, :categoryid, :unitprice)",
            nativeQuery = true)
    void registrarTelas(
            @Param("fabricname") String fabricname,
            @Param("supplierid") Integer supplierid,
            @Param("categoryid") Integer categoryid,
            @Param("unitprice") Double unitprice);

    @Modifying
    @Transactional
    @Query(value = "CALL ActualizarFabric(:fabricid, :fabricname, :supplierid, :categoryid)",
            nativeQuery = true)
    void actualizarTelas(
            @Param("fabricid") Integer fabricid,
            @Param("fabricname") String fabricname,
            @Param("supplierid") Integer supplierid,
            @Param("categoryid") Integer categoryid);
}
