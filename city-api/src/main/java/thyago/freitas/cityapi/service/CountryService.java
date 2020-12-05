package thyago.freitas.cityapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import thyago.freitas.cityapi.model.CountryModel;
import thyago.freitas.cityapi.repository.CountryRepository;

@Service
public class CountryService {

  private final CountryRepository countryRepository;

  @Autowired
  public CountryService(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  public Page<CountryModel> getAll(Pageable pageable) {
    return this.countryRepository.findAll(pageable);
  }

}
