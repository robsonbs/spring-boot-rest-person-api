package br.dev.robsonbs.personapi.controller;

import br.dev.robsonbs.personapi.dto.request.PersonDTO;
import br.dev.robsonbs.personapi.dto.response.MessageResponseDTO;
import br.dev.robsonbs.personapi.exception.PersonNotFoundException;
import br.dev.robsonbs.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {
  private final PersonService personService;
  
  @PostMapping
  @ResponseStatus(CREATED)
  public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO person) {
    return personService.create(person);
  }
  
  @GetMapping
  public List<PersonDTO> listAll() {
    return personService.listAll();
  }
  
  @GetMapping("/{id}")
  public PersonDTO findByID(@PathVariable Long id) throws
          PersonNotFoundException {
    return personService.findById(id);
  }
  
  @PutMapping("/{id}")
  public MessageResponseDTO updateById(@PathVariable Long id,
                                       @RequestBody PersonDTO personDTO) throws
          PersonNotFoundException {
    return personService.update(id, personDTO);
  }
  
  @DeleteMapping("/{id}")
  @ResponseStatus(NO_CONTENT)
  public void deletePerson(@PathVariable Long id) throws
          PersonNotFoundException {
    personService.delete(id);
  }
}
