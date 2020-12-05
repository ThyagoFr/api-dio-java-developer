package thyago.freitas.cityapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thyago.freitas.cityapi.model.CityModel;
import thyago.freitas.cityapi.repository.CityRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class DistanceService {

  private final CityRepository cityRepository;

  @Autowired
  public DistanceService(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  public Double calcDistanceCube(Long city1, Long city2) {
    List<CityModel> cities = cityRepository.findAllById(Arrays.asList(city1,city2));

    return cityRepository.calcDistanceCube(
        cities.get(0).getLatitude(),
        cities.get(0).getLongitude(),
        cities.get(1).getLatitude(),
        cities.get(1).getLongitude()
        );
  }

  public Double calcDistancePoint(Long city1, Long city2){
    return cityRepository.calcDistancePoint(city1,city2);
  }

}
