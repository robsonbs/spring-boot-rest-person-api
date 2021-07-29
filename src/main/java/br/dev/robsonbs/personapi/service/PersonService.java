package br.dev.robsonbs.personapi.service;

import br.dev.robsonbs.personapi.dtos.MessageResponseDTO;
import br.dev.robsonbs.personapi.entity.Person;
import br.dev.robsonbs.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
  private PersonRepository personRepository;
  
  
  public MessageResponseDTO createPerson(Person person){
    Person savedPerson = this.personRepository.save(person);
    return MessageResponseDTO
            .builder()
            .message("Create person with ID = " + savedPerson.getId())
            .build();
  }
}
