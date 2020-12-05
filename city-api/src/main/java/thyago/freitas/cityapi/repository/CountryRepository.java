package thyago.freitas.cityapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thyago.freitas.cityapi.model.CountryModel;

@Repository
public interface CountryRepository extends JpaRepository<CountryModel, Long> {
}
