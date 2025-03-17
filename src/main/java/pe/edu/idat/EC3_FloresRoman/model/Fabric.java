package pe.edu.idat.EC3_FloresRoman.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fabric")
public class Fabric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fabricid;
    private String fabricname;
    private String quantityperroll;
    private Double unitprice;
    private Integer unitsinstock;
    private Integer reorderlevel;
    private Boolean discontinued;

    public Boolean getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
    }

    @ManyToOne
    @JoinColumn(name ="supplierid")
    private Suppliers suppliers;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

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

    public String getQuantityperroll() {
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

    public Integer getUnitsinstock() {
        return unitsinstock;
    }

    public void setUnitsinstock(Integer unitsinstock) {
        this.unitsinstock = unitsinstock;
    }

    public Integer getReorderlevel() {
        return reorderlevel;
    }

    public void setReorderlevel(Integer reorderlevel) {
        this.reorderlevel = reorderlevel;
    }
}