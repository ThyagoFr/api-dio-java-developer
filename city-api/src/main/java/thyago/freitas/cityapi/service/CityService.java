package thyago.freitas.cityapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import thyago.freitas.cityapi.model.CityModel;
import thyago.freitas.cityapi.repository.CityRepository;

@Service
public class CityService {

  private final CityRepository cityRepository;

  @Autowired
  public CityService(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  public Page<CityModel> getAll(Pageable pageable) {
    return this.cityRepository.findAll(pageable);
  }

}
