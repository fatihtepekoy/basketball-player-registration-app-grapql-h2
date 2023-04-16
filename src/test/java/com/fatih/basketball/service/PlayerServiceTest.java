package com.fatih.basketball.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.fatih.basketball.dto.PlayerDTO;
import com.fatih.basketball.exception.MaxPlayerSizeException;
import com.fatih.basketball.exception.PlayerNotFoundException;
import com.fatih.basketball.mappers.IModelMapper;
import com.fatih.basketball.mappers.PlayerModelMapper;
import com.fatih.basketball.model.OrderField;
import com.fatih.basketball.model.OrderType;
import com.fatih.basketball.model.Player;
import com.fatih.basketball.model.Position;
import com.fatih.basketball.repository.PlayerRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

  @Mock
  private PlayerRepository playerRepository;

  @InjectMocks
  private PlayerService playerService;

  @Spy
  private IModelMapper mapper = new PlayerModelMapper();

  @Test
  void contextLoads() {
    assertNotNull(playerService);
  }

  @Test
  void addPlayerReturnsPlayer() {
    //Given
    PlayerDTO playerDTO = new PlayerDTO("fatih", "tepekoy", Position.PG);
    when(playerRepository.save(any(Player.class))).thenReturn(new Player(1L, "fatih", "tepekoy", Position.PG));

    //When
    Player createdPlayer = playerService.addPlayer(playerDTO);

    //Then
    assertThat(createdPlayer.getName()).isEqualTo(playerDTO.getName());
    assertThat(createdPlayer.getSurname()).isEqualTo(playerDTO.getSurname());
    assertThat(createdPlayer.getPosition()).isEqualTo(playerDTO.getPosition());
  }

  @Test
  void addThirteenPlayersReturnException() {
    //Given
    PlayerDTO playerDTO = new PlayerDTO("fatih", "tepekoy", Position.PG);
    when(playerRepository.count()).thenReturn(12L);

    //Then
    Assertions.assertThrows(MaxPlayerSizeException.class, () -> playerService.addPlayer(playerDTO),
        "MaxPlayerSizeException was expected");
  }

  @Test
  void deleteExistingPlayer() {
    //Given
    when(playerRepository.existsById(any(Long.class))).thenReturn(true);

    //When
    boolean deletePlayerStatus = playerService.deletePlayer(1L);

    //Then
    assertThat(deletePlayerStatus).isTrue();
  }

  @Test
  void deleteNonExistingPlayerReturnsException() {
    //Given
    when(playerRepository.existsById(any(Long.class))).thenReturn(false);

    //Then
    Assertions.assertThrows(PlayerNotFoundException.class, () -> playerService.deletePlayer(1L),
        "PlayerNotFoundException was expected");
  }

  @Test
  void listPlayersDescendingOrderByName() {
    //Given
    List<Player> players = new ArrayList<>();
    Player ali = new Player(1L, "Ali", "Tepekoy", Position.PG);
    Player fatih = new Player(2L, "Fatih", "Tepekoy", Position.C);
    Player zeki = new Player(3L, "Zeki", "Tepekoy", Position.SF);
    players.add(zeki);
    players.add(fatih);
    players.add(ali);

    when(playerRepository.findAll()).thenReturn(players);

    //When
    List<Player> allPlayers = playerService.listAllPlayers(OrderField.NAME, OrderType.DESC);

    //Then
    assertThat(allPlayers).containsExactly(zeki, fatih, ali);
  }

}