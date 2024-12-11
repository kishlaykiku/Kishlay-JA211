import { provideRouter, Routes } from '@angular/router';


export const routes: Routes = [

    { path: '', redirectTo: '/players', pathMatch: 'full' },
    {
        path: 'players',
        loadComponent: () =>
        import('./player-list/player-list.component').then(
            (m) => m.PlayerListComponent
        ),
    },
    {
        path: 'players/add',
        loadComponent: () =>
        import('./player-form/player-form.component').then(
            (m) => m.PlayerFormComponent
        ),
    },
    {
        path: 'players/edit/:id',
        loadComponent: () =>
        import('./player-form/player-form.component').then(
            (m) => m.PlayerFormComponent
        ),
    },
];