package com.hexaware.cricbrik.service.impl;

import java.util.List;
// import java.util.UUID;

import com.hexaware.cricbrik.dto.PlayerDTO;
import com.hexaware.cricbrik.entity.Player;
import com.hexaware.cricbrik.exception.ResourceNotFoundException;
import com.hexaware.cricbrik.repository.PlayerRepository;
import com.hexaware.cricbrik.service.IPlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Service: PlayerServiceImpl
 * Description: Implementation of IPlayerService for managing Player operations.
 */
@Service
public class PlayerServiceImpl implements IPlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {

        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerById(Integer playerId) {

        return playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with ID: " + playerId));
    }

    @Override
    public Player addPlayer(PlayerDTO playerDTO) {

        validateRole(playerDTO.getRole());

        Player player = new Player();

        player.setPlayerName(playerDTO.getPlayerName());
        player.setJerseyNumber(playerDTO.getJerseyNumber());
        player.setRole(playerDTO.getRole());
        player.setTotalMatches(playerDTO.getTotalMatches());
        player.setTeamName(playerDTO.getTeamName());
        player.setCountryOrState(playerDTO.getCountryOrState());
        player.setDescription(playerDTO.getDescription());

        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(Integer playerId, PlayerDTO playerDTO) {

        validateRole(playerDTO.getRole());

        Player existingPlayer = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with ID: " + playerId));

        existingPlayer.setPlayerName(playerDTO.getPlayerName());
        existingPlayer.setJerseyNumber(playerDTO.getJerseyNumber());
        existingPlayer.setRole(playerDTO.getRole());
        existingPlayer.setTotalMatches(playerDTO.getTotalMatches());
        existingPlayer.setTeamName(playerDTO.getTeamName());
        existingPlayer.setCountryOrState(playerDTO.getCountryOrState());
        existingPlayer.setDescription(playerDTO.getDescription());

        return playerRepository.save(existingPlayer);
    }

    @Override
    public void deletePlayer(Integer playerId) {

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with ID: " + playerId));

        playerRepository.delete(player);
    }

    @Override
    public List<Player> getPlayersByTeamName(String teamName) {

        return playerRepository.findByTeamName(teamName);
    }

    @Override
    public int updateTeamName(String oldTeamName, String newTeamName) {

        return playerRepository.updateTeamNameForPlayers(oldTeamName, newTeamName);
    }

    private void validateRole(String role) {

        List<String> validRoles = List.of("Batsman", "Bowler", "Keeper", "All Rounder");

        if (validRoles.contains(role) == false) {

            throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
}