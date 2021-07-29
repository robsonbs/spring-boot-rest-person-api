package br.dev.robsonbs.personapi.controller;

import br.dev.robsonbs.personapi.dtos.MessageResponseDTO;
import br.dev.robsonbs.personapi.entity.Person;
import br.dev.robsonbs.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {
  private final PersonService personService;
  
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponseDTO createPerson(@RequestBody Person person) {
    return personService.createPerson(person);
  }
  
  @GetMapping
  public String getBook() {
    return "API test";
  }
}
