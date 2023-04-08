package com.fatih.basketball.service;

import com.fatih.basketball.dto.PlayerDTO;
import com.fatih.basketball.exception.MaxPlayerSizeException;
import com.fatih.basketball.exception.PlayerNotFoundException;
import com.fatih.basketball.mappers.IModelMapper;
import com.fatih.basketball.model.OrderField;
import com.fatih.basketball.model.OrderType;
import com.fatih.basketball.model.Player;
import com.fatih.basketball.repository.PlayerRepository;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PlayerService {

  private PlayerRepository playerRepository;
  private IModelMapper mapper;

  public PlayerService(PlayerRepository playerRepository, IModelMapper mapper) {
    this.playerRepository = playerRepository;
    this.mapper = mapper;
  }

  public boolean deletePlayer(Long id) {
    if (playerRepository.existsById(id)) {
      playerRepository.deleteById(id);
      log.info("Player deleted. ID :{} ", id);
      return true;
    }
    log.warn("Delete operation is not successful. Player ID {} is not found. Exception occurred", id);
    throw new PlayerNotFoundException(String.valueOf(id));
  }

  public List<Player> listAllPlayers(OrderField orderField, OrderType orderType) {
    List<Player> playerList = playerRepository.findAll();
    switch (orderField) {
      case NAME -> playerList.sort(Comparator.comparing(Player::getName));
      case SURNAME -> playerList.sort(Comparator.comparing(Player::getSurname));
      case POSITION -> playerList.sort(Comparator.comparing(Player::getPosition));
    }

    if (orderType == OrderType.DESC) {
      Collections.reverse(playerList);
    }

    return playerList;
  }

  public Player addPlayer(PlayerDTO playerDTO) {
    Player player = mapper.convertDTOToModel(playerDTO);
    if (playerRepository.count() < 12) {
      Player savedPlayer = playerRepository.save(player);
      if (savedPlayer.getId() != null) {
        log.info("Player ID {} is added. Player details : {}", savedPlayer.getId(), savedPlayer);
        return savedPlayer;
      }
    }
    log.warn("Player count is 12 currently. A team can have 12 player at most. No more player can be added.");
    throw new MaxPlayerSizeException();
  }
}


