package com.fatih.basketball.repository;

import com.fatih.basketball.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}