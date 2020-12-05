package thyago.freitas.cityapi.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "estado")
@TypeDefs(
    {
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
    }
)
@Data
public class StateModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome", length = 60)
  private String name;

  @Column(name = "uf", length = 2)
  private String code;

  private Integer ibge;

  @Column(name = "pais")
  private Integer countryId;

  @Type(type = "jsonb")
  @Basic(fetch = FetchType.LAZY)
  @Column(name = "ddd", columnDefinition = "jsonb")
  private List<Integer> ddd;

}
