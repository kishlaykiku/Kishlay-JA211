import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


export interface Player {
    playerId: string;
    playerName: string;
    jerseyNumber: number;
    role: string;
    totalMatches: number;
    teamName: string;
    countryOrState: string;
    description: string;
}

@Injectable({
    providedIn: 'root',
})
export class PlayerService {

    private baseUrl = 'http://localhost:8080/api/players';

    constructor(private http: HttpClient) { }

    // Fetch all players
    getPlayers(): Observable<Player[]> {

        return this.http.get<Player[]>(`${this.baseUrl}/getall`);
    }

    // Add a player
    addPlayer(player: Player): Observable<Player> {

        return this.http.post<Player>(`${this.baseUrl}/add`, player);
    }

    // Fetch a player by ID
    getPlayerById(id: string): Observable<Player> {

        return this.http.get<Player>(`${this.baseUrl}/get/${id}`);
    }    

    // Update a player by ID
    updatePlayer(player: Player): Observable<Player> {

        return this.http.put<Player>(`${this.baseUrl}/update/${player.playerId}`, player);
    }

    // Delete a player by ID
    deletePlayer(playerId: string): Observable<void> {

        return this.http.delete<void>(`${this.baseUrl}/delete/${playerId}`);
    }

    // Fetch all players by team name
    getPlayersByTeamName(teamName: string): Observable<Player[]> {

        return this.http.get<Player[]>(`${this.baseUrl}/get/team/${teamName}`);
    }
}