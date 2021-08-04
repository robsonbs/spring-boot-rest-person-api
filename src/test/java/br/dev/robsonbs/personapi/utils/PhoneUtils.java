package br.dev.robsonbs.personapi.utils;

import br.dev.robsonbs.personapi.dto.request.PersonDTO;
import br.dev.robsonbs.personapi.dto.request.PhoneDTO;
import br.dev.robsonbs.personapi.entity.Phone;
import br.dev.robsonbs.personapi.enums.PhoneType;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class PhoneUtils {
  
  private static final String PHONE_NUMBER = "1199999-9999";
  private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
  private static final long PHONE_ID = 1L;
  
  public static PhoneDTO createFakeDTO() {
    return PhoneDTO.builder()
            .number(PHONE_NUMBER)
            .type(PHONE_TYPE)
            .build();
  }
  
  public static Phone createFakeEntity() {
    return Phone.builder()
            .id(PHONE_ID)
            .number(PHONE_NUMBER)
            .type(PHONE_TYPE)
            .build();
  }
  public static String asJsonString(PersonDTO personDTO) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
      objectMapper.registerModules(new JavaTimeModule());
      
      return objectMapper.writeValueAsString(personDTO);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
