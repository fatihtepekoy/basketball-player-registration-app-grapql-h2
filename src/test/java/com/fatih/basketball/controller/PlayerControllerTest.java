package com.fatih.basketball.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.fatih.basketball.dto.PlayerDTO;
import com.fatih.basketball.model.OrderField;
import com.fatih.basketball.model.OrderType;
import com.fatih.basketball.model.Player;
import com.fatih.basketball.model.Position;
import com.fatih.basketball.service.PlayerService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;


@GraphQlTest(PlayerController.class)
class PlayerControllerTest {

  @Autowired
  private GraphQlTester graphQlTester;

  @MockBean
  private PlayerService playerService;

  @Test
  void contextLoads() {
    assertNotNull(graphQlTester);
    assertNotNull(playerService);
  }

  @Test
  void addPlayerReturnsPlayer() {
    //Given
    String document = """
            mutation {
                 addPlayer(player :{name: "fatih", surname: "tepekoy", position: "PG"}) {
                   id, name, surname, position
                 }
             }
        """;
    PlayerDTO playerDTO = new PlayerDTO("fatih", "tepekoy", Position.PG);
    Player expectedPlayer = new Player(1L, "fatih", "tepekoy", Position.PG);
    when(playerService.addPlayer(playerDTO)).thenReturn(expectedPlayer);

    //When
    Player actualPlayer = graphQlTester.document(document)
                                       .execute()
                                       .path("data.addPlayer")
                                       .entity(Player.class).get();

    //Then
    assertThat(actualPlayer).isEqualTo(expectedPlayer);
  }

  @Test
  void listAllBooksQueryReturnsAllBooks() {
    //Given
    List<Player> players = new ArrayList<>();
    var fatih = new Player(1L, "fatih", "Tepekoy", Position.PG);
    var jordan = new Player(2L, "jordan", "Tepekoy", Position.SF);
    players.add(fatih);
    players.add(jordan);

    String document = """
            query {
                listAllPlayers (orderField: NAME orderType: DESC)  {
                    id, name, surname, position
                }
            }
        """;

    when(playerService.listAllPlayers(OrderField.NAME, OrderType.DESC)).thenReturn(players);

    //When
    List<Player> listAllPlayers = graphQlTester.document(document)
                                               .execute()
                                               .path("data.listAllPlayers")
                                               .entityList(Player.class)
                                               .get();

    //Then
    assertThat(listAllPlayers).isEqualTo(players);
  }

  @Test
  void deletePlayerReturnsPlayer() {
    //Given
    String document = """
            mutation {
                  deletePlayer(id:1)
              }
        """;

    when(playerService.deletePlayer(1L)).thenReturn(true);

    //When
    Boolean deletePlayerStatus = graphQlTester.document(document)
                                              .execute()
                                              .path("data.deletePlayer")
                                              .entity(Boolean.class)
                                              .get();

    //Then
    assertThat(deletePlayerStatus).isTrue();
  }

}