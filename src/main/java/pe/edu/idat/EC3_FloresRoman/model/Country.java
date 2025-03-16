package pe.edu.idat.EC3_FloresRoman.model;

import jakarta.persistence.*;

import java.text.DecimalFormat;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String Code;
  private String Name;
  private String Continent;
  private String Region;
  private Double SurfaceArea;
  private Double IndepYear;
  private Integer Population;
  private DecimalFormat LifeExpectancy;
  private DecimalFormat GNP;
  private DecimalFormat GNPOId;
  private String LocalName;
  private String GovernmentForm;
  private String HeadOfState;
  private Integer Capital;
  private String Code2;

  @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  @JoinTable(name = "Country_rol", joinColumns = @JoinColumn(name = "code"), inverseJoinColumns = @JoinColumn(name = "idrol"))
  private Set<Rol> roles;
  public String getCode() {
    return Code;
  }

  public void setCode(String code) {
    Code = code;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public String getContinent() {
    return Continent;
  }

  public void setContinent(String continent) {
    Continent = continent;
  }

  public String getRegion() {
    return Region;
  }

  public void setRegion(String region) {
    Region = region;
  }

  public Double getSurfaceArea() {
    return SurfaceArea;
  }

  public void setSurfaceArea(Double surfaceArea) {
    SurfaceArea = surfaceArea;
  }

  public Double getIndepYear() {
    return IndepYear;
  }

  public void setIndepYear(Double indepYear) {
    IndepYear = indepYear;
  }

  public Integer getPopulation() {
    return Population;
  }

  public void setPopulation(Integer population) {
    Population = population;
  }

  public DecimalFormat getLifeExpectancy() {
    return LifeExpectancy;
  }

  public void setLifeExpectancy(DecimalFormat lifeExpectancy) {
    LifeExpectancy = lifeExpectancy;
  }

  public DecimalFormat getGNP() {
    return GNP;
  }

  public void setGNP(DecimalFormat GNP) {
    this.GNP = GNP;
  }

  public DecimalFormat getGNPOId() {
    return GNPOId;
  }

  public void setGNPOId(DecimalFormat GNPOId) {
    this.GNPOId = GNPOId;
  }

  public String getLocalName() {
    return LocalName;
  }

  public void setLocalName(String localName) {
    LocalName = localName;
  }

  public String getGovernmentForm() {
    return GovernmentForm;
  }

  public void setGovernmentForm(String governmentForm) {
    GovernmentForm = governmentForm;
  }

  public String getHeadOfState() {
    return HeadOfState;
  }

  public void setHeadOfState(String headOfState) {
    HeadOfState = headOfState;
  }

  public Integer getCapital() {
    return Capital;
  }

  public void setCapital(Integer capital) {
    Capital = capital;
  }

  public String getCode2() {
    return Code2;
  }

  public void setCode2(String code2) {
    Code2 = code2;
  }
}
