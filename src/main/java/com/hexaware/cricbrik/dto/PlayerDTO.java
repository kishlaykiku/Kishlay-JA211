package com.hexaware.cricbrik.dto;

import lombok.Data;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/*
 * DTO: PlayerDTO
 * Description: PlayerDTO is used to transfer the player details between service and controller
 * Map: PlayerDTO is mapped to the Player entity
 */
@Data
public class PlayerDTO {
    
    private UUID playerId;

    @NotNull(message = "Player name is required.")
    @Size(min = 2, max = 100, message = "Player name must be between 2 and 100 characters.")
    private String playerName;

    @NotNull(message = "Jersey number is required.")
    private Integer jerseyNumber;

    @NotNull(message = "Role is required.")
    @Size(min = 3, max = 20, message = "Role must be between 3 and 20 characters.")
    private String role;

    @NotNull(message = "Total matches are required.")
    private Integer totalMatches;

    @NotNull(message = "Team name is required.")
    @Size(min = 2, max = 100, message = "Team name must be between 2 and 100 characters.")
    private String teamName;

    @NotNull(message = "Country or state name is required.")
    @Size(min = 2, max = 100, message = "Country/State name must be between 2 and 100 characters.")
    private String countryOrState;

    private String description;
}