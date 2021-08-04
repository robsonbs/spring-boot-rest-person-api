package br.dev.robsonbs.personapi.service;

import br.dev.robsonbs.personapi.dto.mapper.PersonMapper;
import br.dev.robsonbs.personapi.dto.request.PersonDTO;
import br.dev.robsonbs.personapi.dto.response.MessageResponseDTO;
import br.dev.robsonbs.personapi.entity.Person;
import br.dev.robsonbs.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
  private final PersonRepository personRepository;
  private final PersonMapper personMapper;
  
  public MessageResponseDTO create(PersonDTO personDTO) {
    Person person = personMapper.toModel(personDTO);
    Person savedPerson = personRepository.save(person);
  
    return MessageResponseDTO
            .builder()
            .message("Person created with ID " + savedPerson.getId())
            .build();
  }
  
  public List<PersonDTO> listAll() {
    List<Person> allPeople = personRepository.findAll();
    return allPeople
            .stream()
            .map(personMapper::toDTO)
            .collect(Collectors.toList());
  }
}
