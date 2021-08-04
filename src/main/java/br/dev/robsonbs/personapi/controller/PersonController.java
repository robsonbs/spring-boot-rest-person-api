package br.dev.robsonbs.personapi.controller;

import br.dev.robsonbs.personapi.dto.request.PersonDTO;
import br.dev.robsonbs.personapi.dto.response.MessageResponseDTO;
import br.dev.robsonbs.personapi.exception.PersonNotFoundException;
import br.dev.robsonbs.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {
  private final PersonService personService;
  
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
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
    return personService.findByID(id);
  }
}
