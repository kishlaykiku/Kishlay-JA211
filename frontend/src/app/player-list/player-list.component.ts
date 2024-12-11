import { Component, OnInit } from '@angular/core';
import { PlayerService, Player } from '../services/player.service';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterModule } from '@angular/router';


@Component({
    selector: 'app-player-list',
    standalone: true,
    imports: [CommonModule, RouterModule],
    templateUrl: './player-list.component.html',
    styleUrls: ['./player-list.component.css'],
})
export class PlayerListComponent implements OnInit {

    players: Player[] = [];
    isLoading = true;
    isError = false;
    errorMessage = '';
    isFiltered = false;

    constructor(private playerService: PlayerService, private route: ActivatedRoute) {}

    ngOnInit(): void {

        // Check for the query parameter to filter by team name
        this.route.queryParams.subscribe(params => {

            const teamName = params['teamName'];

            if (teamName) {
                this.isFiltered = true;
                this.fetchPlayersByTeamName(teamName);
            }
            else {
                if (!this.isFiltered) {
                    this.fetchAllPlayers();
                }
            }
        });
    }

    fetchAllPlayers(): void {

        this.isLoading = true;
        this.isError = false;
        this.isFiltered = true;
        this.playerService.getPlayers().subscribe({
            next: (data) => {
                this.players = this.sortPlayersByName(data);
                this.isLoading = false;
            },
            error: (err) => {
                console.error('Failed to fetch players:', err);
                this.isError = true;
                this.errorMessage = 'Failed to fetch players. Please try again later.';
                this.isLoading = false;
            },
        });
    }

    fetchPlayersByTeamName(teamName: string): void {

        this.isLoading = true;
        this.isError = false;
        this.isFiltered = false;
        this.playerService.getPlayersByTeamName(teamName).subscribe({
            next: (data) => {
                this.players = this.sortPlayersByName(data);
                this.isLoading = false;
            },
            error: (err) => {
                console.error('Failed to fetch players by team name:', err);
                this.isError = true;
                this.errorMessage = 'Failed to fetch players by team name. Please try again later.';
                this.isLoading = false;
            },
        });
    }

    // Sort players by name
    sortPlayersByName(players: Player[]): Player[] {

        return players.sort((a, b) => a.playerName.localeCompare(b.playerName));
    }

    // Delete a player by ID and update the list of players
    deletePlayer(playerId: string): void {

        if (confirm('Are you sure you want to delete this player?')) {

            this.playerService.deletePlayer(playerId).subscribe({
                next: () => {
                    alert('Player deleted successfully!');
                    this.players = this.players.filter(player => player.playerId !== playerId);
                },
                error: (err) => {
                    console.error('Failed to delete player:', err);
                    alert('Failed to delete the player. Please try again later.');
                }
            });
        }
    }
}