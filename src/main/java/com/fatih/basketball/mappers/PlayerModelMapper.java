package com.fatih.basketball.mappers;

import com.fatih.basketball.dto.PlayerDTO;
import com.fatih.basketball.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerModelMapper implements IModelMapper {

  @Override
  public Player convertDTOToModel(PlayerDTO playerDTO) {
    return Player.builder()
                 .name(playerDTO.getName())
                 .surname(playerDTO.getSurname())
                 .position(playerDTO.getPosition())
                 .build();
  }
}
