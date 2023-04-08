package com.fatih.basketball.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.fatih.basketball.model.Player;
import com.fatih.basketball.model.Position;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PlayerRepositoryTest {

  @Autowired
  private PlayerRepository playerRepository;

  @Test
  void injectedComponentsAreNotNull() {
    assertThat(playerRepository).isNotNull();
  }

  @Test
  void addPlayer() {
    //When
    Player player = playerRepository.save(new Player("Fatih", "Tepekoy", Position.PG));

    //Then
    assertThat(player).isNotNull();
    assertThat(player.getId()).isGreaterThan(0);
  }

  @Test
  void deletePlayer() {
    //When
    Player player = playerRepository.save(new Player("Fatih", "Tepekoy", Position.PG));

    //Then
    Assertions.assertDoesNotThrow(() -> playerRepository.deleteById(1L));
    Optional<Player> playerOptional = playerRepository.findById(player.getId());
    assertThat(playerOptional).isEmpty();
  }

  @Test
  void findAll() {
    //When
    Player ali = new Player("Ali", "Tepekoy", Position.PG);
    Player fatih = new Player("Fatih", "Tepekoy", Position.C);
    Player zeki = new Player("Zeki", "Tepekoy", Position.SF);
    playerRepository.save(ali);
    playerRepository.save(fatih);
    playerRepository.save(zeki);

    //Then
    assertThat(playerRepository.findAll()).contains(ali, fatih, zeki);
  }

}
