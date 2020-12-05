package thyago.freitas.cityapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import thyago.freitas.cityapi.model.StateModel;
import thyago.freitas.cityapi.repository.StateRepository;

@Service
public class StateService {

  private final StateRepository stateRepository;

  @Autowired
  public StateService(StateRepository stateRepository) {
    this.stateRepository = stateRepository;
  }

  public Page<StateModel> getAll(Pageable pageable) {
    return this.stateRepository.findAll(pageable);
  }

}
