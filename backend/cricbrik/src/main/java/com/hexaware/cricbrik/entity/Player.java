package com.hexaware.cricbrik.entity;

// import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * Entity: Player
 * Description: Player entity is used to store the player details
 * Map: Player entity is mapped to the players table in the database
 */
@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id", nullable = false, unique = true)
    private Integer playerId;

    @Column(name = "player_name", nullable = false)
    private String playerName;

    @Column(name = "jersey_number", nullable = false, unique = true)
    private int jerseyNumber;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "total_matches", nullable = false)
    private int totalMatches;

    @Column(name = "team_name", nullable = false)
    private String teamName;

    @Column(name = "country_or_state", nullable = false)
    private String countryOrState;

    @Column(name = "description")
    private String description;

    // Assigning a UID before inserting the player into the database
    // @PrePersist
    // public void onCreate() {

    //     if(playerId == null) {

    //         playerId = UUID.randomUUID();
    //     }
    // }
}