package com.fatih.basketball.dto;

import com.fatih.basketball.model.Position;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class PlayerDTO {

  @Size(max = 50, min = 2, message = "Invalid name")
  @NotNull
  private String name;

  @Size(max = 50, min = 2, message = "Invalid surname")
  @NotNull
  private String surname;

  @Enumerated(EnumType.STRING)
  @NotNull
  private Position position;

}
