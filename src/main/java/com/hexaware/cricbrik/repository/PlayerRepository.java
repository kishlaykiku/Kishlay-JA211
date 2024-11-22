package com.hexaware.cricbrik.repository;

import java.util.UUID;
import java.util.List;

import com.hexaware.cricbrik.entity.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
 * Repository: PlayerRepository
 * Description: PlayerRepository is used to interact with the players table in the database
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {

    List<Player> findByTeamName(String teamName);
}