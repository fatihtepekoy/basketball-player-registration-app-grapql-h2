package com.fatih.basketball.controller;

import com.fatih.basketball.dto.PlayerDTO;
import com.fatih.basketball.model.OrderField;
import com.fatih.basketball.model.OrderType;
import com.fatih.basketball.model.Player;
import com.fatih.basketball.service.PlayerService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;


@Controller
@Validated
public class PlayerController {

  private PlayerService playerService;

  public PlayerController(PlayerService playerService) {
    this.playerService = playerService;
  }

  @MutationMapping
  public Player addPlayer(@Argument @Valid PlayerDTO player) {
    return playerService.addPlayer(player);
  }

  @MutationMapping
  public boolean deletePlayer(@Argument Long id) {
    return playerService.deletePlayer(id);
  }

  @QueryMapping
  public List<Player> listAllPlayers(@Argument OrderField orderField, @Argument OrderType orderType) {
    return playerService.listAllPlayers(orderField, orderType);
  }

}
