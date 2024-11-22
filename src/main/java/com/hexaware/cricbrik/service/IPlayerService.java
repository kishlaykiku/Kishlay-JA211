package com.hexaware.cricbrik.service;

import java.util.List;
import java.util.UUID;

import com.hexaware.cricbrik.dto.PlayerDTO;
import com.hexaware.cricbrik.entity.Player;


/*
 * Service: IPlayerService
 * Description: IPlayerService is an interface used to define the methods for PlayerService
 */
public interface IPlayerService {

    // Retrieve all the players
    List<Player> getAllPlayers();

    // Retrieve players by their ID
    Player getPlayerById(UUID playerId);

    // Add player
    Player addPlayer(PlayerDTO playerDTO);

    // Update player
    Player updatePlayer(UUID playerId, PlayerDTO playerDTO);

    // Delete player
    void deletePlayer(UUID playerId);

    // Retrieve players by team name
    List<Player> getPlayersByTeamName(String teamName);
}