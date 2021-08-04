package br.dev.robsonbs.personapi.dto.mapper;

import br.dev.robsonbs.personapi.dto.request.PersonDTO;
import br.dev.robsonbs.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {
  @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
  Person toModel(PersonDTO dto);
  
  PersonDTO toDTO(Person dto);
}
