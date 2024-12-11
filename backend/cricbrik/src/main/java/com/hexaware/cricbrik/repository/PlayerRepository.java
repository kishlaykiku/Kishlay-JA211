package com.hexaware.cricbrik.repository;

import java.util.UUID;
import java.util.List;

import com.hexaware.cricbrik.entity.Player;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/*
 * Repository: PlayerRepository
 * Description: PlayerRepository is used to interact with the players table in the database
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {

    List<Player> findByTeamName(String teamName);

    @Modifying
    @Transactional
    @Query("Update Player p SET p.teamName = :newTeamName WHERE p.teamName = :oldTeamName")
    int updateTeamNameForPlayers(String oldTeamName, String newTeamName);
}