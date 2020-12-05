package thyago.freitas.cityapi.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "pais")
@Data
public class CountryModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome", length = 60)
  private String name;

  @Column(name = "nome_pt", length = 60)
  private String portugueseName;

  private Integer bacen;

  @Column(name = "sigla", length = 2)
  private String code;

}
