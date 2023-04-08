package com.fatih.basketball.mappers;

import com.fatih.basketball.dto.PlayerDTO;
import com.fatih.basketball.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerModelMapper implements IModelMapper {

  @Override
  public Player convertDTOToModel(PlayerDTO playerDTO) {
    Player player = new Player();
    player.setName(playerDTO.getName());
    player.setSurname(playerDTO.getSurname());
    player.setPosition(playerDTO.getPosition());
    return player;
  }
}
