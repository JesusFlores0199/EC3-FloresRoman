package pe.edu.idat.EC3_FloresRoman.repository.projection;

import org.springframework.beans.factory.annotation.Value;

public interface FabricStockProjection {
    @Value("#{target.FabricID}")
    Integer getFabricId();
    @Value("#{target.FabricName}")
    String getFabricName();
    @Value("#{target.UnitPrice}")
    Double getUnitPrice();
    @Value("#{target.CategoryName}")
    String getCategoryName();
    @Value("#{target.CompanyName}")
    String getCompanyName();
    @Value("#{target.UnitsInStock}")
    Integer getUnitsInStock();
}
