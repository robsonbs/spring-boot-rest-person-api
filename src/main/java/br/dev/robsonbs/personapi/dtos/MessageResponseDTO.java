package br.dev.robsonbs.personapi.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {
  
  private String message;
}
