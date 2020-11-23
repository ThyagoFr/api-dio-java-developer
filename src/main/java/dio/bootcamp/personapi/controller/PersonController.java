package dio.bootcamp.personapi.controller;

import dio.bootcamp.personapi.dto.PersonDTO;
import dio.bootcamp.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    ResponseEntity<List<PersonDTO>> getPersons() {
        return ResponseEntity.ok(personService.getPersons());
    }

    @GetMapping("/{id}")
    ResponseEntity<PersonDTO> getPerson(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getPerson(id));
    }

    @PostMapping
    ResponseEntity<?> postPerson(@Valid @RequestBody PersonDTO personDTO) {
        Long id = personService.createPerson(personDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<?> putPerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        personService.putPerson(id, personDTO);
        return ResponseEntity.noContent().build();
    }

}
