package com.hexaware.cricbrik.controller;

import java.util.List;
// import java.util.UUID;

import com.hexaware.cricbrik.dto.PlayerDTO;
import com.hexaware.cricbrik.entity.Player;
import com.hexaware.cricbrik.service.IPlayerService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * REST Controller for managing players.
 * Description: PlayerController is a REST controller class used to manage player details.
 */
@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private IPlayerService playerService;

    // Get all players
    @GetMapping("/getall")
    public ResponseEntity<List<Player>> getAllPlayers() {

        List<Player> players = playerService.getAllPlayers();

        return ResponseEntity.ok(players);
    }

    // Get player by ID
    @GetMapping("/get/{playerId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Integer playerId) {

        Player player = playerService.getPlayerById(playerId);

        return ResponseEntity.ok(player);
    }

    // Add a new player
    @PostMapping("/add")
    public ResponseEntity<Player> addPlayer(@Valid @RequestBody PlayerDTO playerDTO) {

        Player createdPlayer = playerService.addPlayer(playerDTO);

        return ResponseEntity.status(201).body(createdPlayer);
    }

    // Update player details
    @PutMapping("/update/{playerId}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Integer playerId, @Valid @RequestBody PlayerDTO playerDTO) {

        Player updatedPlayer = playerService.updatePlayer(playerId, playerDTO);

        return ResponseEntity.ok(updatedPlayer);
    }

    // Delete player by ID
    @DeleteMapping("/delete/{playerId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Integer playerId) {

        playerService.deletePlayer(playerId);

        return ResponseEntity.noContent().build();
    }

    // Get players by team name
    @GetMapping("/get/team/{teamName}")
    public ResponseEntity<List<Player>> getPlayersByTeamName(@PathVariable String teamName) {

        List<Player> players = playerService.getPlayersByTeamName(teamName);

        return ResponseEntity.ok(players);
    }

    // Update team name for players
    @PutMapping("/update-team-name")
    public ResponseEntity<String> updateTeamName(@RequestParam String oldTeamName, @RequestParam String newTeamName) {

        int updatedCount = playerService.updateTeamName(oldTeamName, newTeamName);

        return ResponseEntity.ok(updatedCount + " players updated successfully.");
    }
}