package thyago.freitas.cityapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thyago.freitas.cityapi.model.StateModel;
import thyago.freitas.cityapi.service.StateService;

@RestController
@RequestMapping("/api/v1/states")
public class StateResource {

  private final StateService stateService;

  @Autowired
  StateResource(StateService stateService) {
    this.stateService = stateService;
  }

  @GetMapping
  public ResponseEntity<Page<StateModel>> getAll(Pageable pageable) {
    Page<StateModel> states = stateService.getAll(pageable);
    return ResponseEntity.ok(states);
  }

}
