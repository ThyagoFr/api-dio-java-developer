package dio.bootcamp.personapi.repository;

import dio.bootcamp.personapi.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonModel, Long> {

    PersonModel findByCpf(String cpf);

}
