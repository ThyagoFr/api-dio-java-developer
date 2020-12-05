package thyago.freitas.cityapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thyago.freitas.cityapi.model.StateModel;

@Repository
public interface StateRepository extends JpaRepository<StateModel, Long> {
}
