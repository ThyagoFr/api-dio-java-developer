package thyago.freitas.cityapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thyago.freitas.cityapi.model.CountryModel;
import thyago.freitas.cityapi.service.CountryService;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryResource {

  private final CountryService countryService;

  @Autowired
  CountryResource(CountryService countryService) {
    this.countryService = countryService;
  }

  @GetMapping
  public ResponseEntity<Page<CountryModel>> getAll(Pageable pageable) {
    Page<CountryModel> countries = countryService.getAll(pageable);
    return ResponseEntity.ok(countries);
  }

}
