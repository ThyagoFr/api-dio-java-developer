package thyago.freitas.cityapi.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "cidade")
@Data
public class CityModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome")
  private String name;

  @Column(name = "uf")
  private Integer state;

  private Integer ibge;

  @Column(name = "lat_lon")
  private String geolocation;

  private Double latitude;

  private Double longitude;

  @Column(name = "cod_tom")
  private Integer codTom;

}