import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterOutlet, RouterModule } from '@angular/router';


@Component({
    selector: 'app-root',
    standalone: true,
    imports: [RouterOutlet, RouterModule, FormsModule, CommonModule],
    templateUrl: './app.component.html',
    styleUrl: './app.component.css'
})
export class AppComponent {

    teamName: string = '';

    constructor(private router: Router) { }

    searchPlayers(): void {

        if (this.teamName.trim()) {

            this.router.navigate(['/players'], { queryParams: { teamName: this.teamName.trim() } });
        }
    }
}