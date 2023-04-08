package com.fatih.basketball.mappers;

import com.fatih.basketball.dto.PlayerDTO;
import com.fatih.basketball.model.Player;

public interface IModelMapper {

  // TO DO - we can add a parent class type here for polymorphism in future
  Player convertDTOToModel(PlayerDTO playerDTO);

}
