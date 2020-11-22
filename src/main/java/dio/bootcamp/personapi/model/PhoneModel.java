package dio.bootcamp.personapi.model;

import dio.bootcamp.personapi.enums.PhoneType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PhoneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @Column(nullable = false)
    private String number;
}
