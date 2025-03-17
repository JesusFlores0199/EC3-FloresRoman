package pe.edu.idat.EC3_FloresRoman.dto;

public class FabricDto implements DtoEntity{
    private Integer fabricid;
    private String fabricname;
    private String quantityperroll;
    private Double unitprice;

    public CategoryDto getCategory() {
        return category;
    }
    public void setCategory(CategoryDto category) {
        this.category = category;
    }
    private CategoryDto category;
    public SuppliersDto getSuppliers(){return suppliers;}
    public void setSuppliers(SuppliersDto suppliers){this.suppliers = suppliers;}
    private SuppliersDto suppliers;


    public Integer getFabricid() {
        return fabricid;
    }

    public void setFabricid(Integer fabricid) {
        this.fabricid = fabricid;
    }

    public String getFabricname() {
        return fabricname;
    }

    public void setFabricname(String fabricname) {
        this.fabricname = fabricname;
    }

    public String getQuantityperrool() {
        return quantityperroll;
    }

    public void setQuantityperroll(String quantityperroll) {
        this.quantityperroll = quantityperroll;
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }
}
