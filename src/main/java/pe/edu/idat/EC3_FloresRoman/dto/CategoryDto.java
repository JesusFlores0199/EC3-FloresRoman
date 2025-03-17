package pe.edu.idat.EC3_FloresRoman.dto;

public class CategoryDto implements DtoEntity{
    private Integer categoryid;
    private String categoryname;

    public Integer getCategoryid(){return categoryid;}
    public void setCategoryid(Integer categoryid){this.categoryid = categoryid;}
    public String getCategoryname() {
        return categoryname;
    }
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}
