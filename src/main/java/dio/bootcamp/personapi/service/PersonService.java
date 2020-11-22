package dio.bootcamp.personapi.service;

import dio.bootcamp.personapi.dto.PersonDTO;
import dio.bootcamp.personapi.exceptions.BadRequest;
import dio.bootcamp.personapi.exceptions.ResourceNotFound;
import dio.bootcamp.personapi.mappers.PersonMapper;
import dio.bootcamp.personapi.model.PersonModel;
import dio.bootcamp.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDTO getPerson(Long id){
        PersonModel person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Usuario nao encontrado"));
        return personMapper.toDTO(person);
    }

    public List<PersonDTO> getPersons(){
        return personRepository.findAll().stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public Long createPerson(PersonDTO personDTO) {
        if (personRepository.findByCpf(personDTO.getCpf()) != null) {
            throw new BadRequest("CPF já utilizado");
        }
        return personRepository.save(personMapper.toModel(personDTO)).getId();
    }

}
