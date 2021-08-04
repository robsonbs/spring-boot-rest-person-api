package br.dev.robsonbs.personapi.service;

import br.dev.robsonbs.personapi.dto.mapper.PersonMapper;
import br.dev.robsonbs.personapi.dto.response.MessageResponseDTO;
import br.dev.robsonbs.personapi.dto.request.PersonDTO;
import br.dev.robsonbs.personapi.entity.Person;
import br.dev.robsonbs.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
  private final PersonRepository personRepository;
  
  private PersonMapper personMapper;
  
  public MessageResponseDTO create(PersonDTO personDTO) {
    Person person = personMapper.toModel(personDTO);
    Person savedPerson = personRepository.save(person);
    
    MessageResponseDTO messageResponse = MessageResponseDTO.builder()
            .message("Person created with ID " + savedPerson.getId())
            .build();
    
    return messageResponse;
  }
}
