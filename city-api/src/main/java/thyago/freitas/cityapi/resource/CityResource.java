package thyago.freitas.cityapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thyago.freitas.cityapi.model.CityModel;
import thyago.freitas.cityapi.service.CityService;

@RestController
@RequestMapping("/api/v1/cities")
public class CityResource {

  private final CityService cityService;

  @Autowired
  CityResource(CityService cityService) {
    this.cityService = cityService;
  }

  @GetMapping
  public ResponseEntity<Page<CityModel>> getAll(Pageable pageable) {
    Page<CityModel> cities = cityService.getAll(pageable);
    return ResponseEntity.ok(cities);
  }

}
