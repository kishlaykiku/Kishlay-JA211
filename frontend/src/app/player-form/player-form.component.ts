import { Component, OnInit } from '@angular/core';
import { PlayerService, Player } from '../services/player.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
    selector: 'app-player-form',
    standalone: true,
    imports: [FormsModule, CommonModule],
    templateUrl: './player-form.component.html',
    styleUrl: './player-form.component.css'
})
export class PlayerFormComponent {

    player: Partial<Player> = {};
    isEdit = false;

    constructor(private playerService: PlayerService, private router: Router, private route: ActivatedRoute) { }

    ngOnInit(): void {

        const playerId = this.route.snapshot.paramMap.get('id');

        if (playerId) {

            this.isEdit = true;
            this.playerService.getPlayerById(playerId).subscribe({
                next: (data) => {
                    this.player = data;
                },
                error: (err) => {
                    console.error('Failed to fetch player details:', err);
                    alert('Failed to fetch player details. Please try again later.');
                },
            });
        }
    }

    onSubmit(form: any) {

        if (form.valid) {

            if (this.isEdit) {

                this.playerService.updatePlayer(this.player as Player).subscribe({
                     next: () => {
                        alert('Player updated successfully!');
                        this.router.navigate(['/players']);
                    },
                    error: (err) => {
                        console.error('Failed to update player:', err);
                        alert('Failed to update player. Please try again later.');
                    },
                });
            }
            else {

                this.playerService.addPlayer(this.player as Player).subscribe({
                    next: () => {
                        alert('Player added successfully!');
                        this.router.navigate(['/players']);
                    },
                    error: (err) => {
                        console.error('Failed to add player:', err);
                        alert('Failed to add player. Please try again later.');
                    },
                });
            }
        }
    }
}