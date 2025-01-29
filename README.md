# Cricbrik - Cricket Player Management App

Cricbrik is a web application built with Spring Boot and Angular that allows users to manage cricket player information, including searching for players by team name, adding new players, and viewing a list of players.

## Features

- **Player List**: View a list of all cricket players.
- **Add Player**: Add new players to the database.
- **Search Players**: Search for players by their team name.
- **Routing**: Navigate between different pages seamlessly.


## Technologies Used

### Frontend
- Angular (Standalone Components)
- Bootstrap (For UI Styling)
- Typescript
- RouterModule (For Navigation)
- FormsModule (For Handling Forms)

### Backend
- Spring Boot
- Spring Data JPA
- MySQL
- REST APIs


## Installation

### Prerequisites
- Node.js (v16+ recommended)
- Angular CLI (if not installed, run npm install -g @angular/cli)
- Java 17+
- Maven
- MySQL Database

### Steps to Run Locally
#### Backend
1. Navigate to the backend folder:
   ```console
   cd cricbrik/backend
   ```
2. Configure ```application.properties``` with database credentials:
   ```console
   spring.datasource.url=jdbc:mysql://localhost:3306/cdc_cricbrik
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Build and run the Spring Boot application:
   ```console
   mvn spring-boot:run
   ```
4. The backend will be available at ```http://localhost:8080/```.

#### Frontend
1. Clone the repository:
   ```console
   git clone https://github.com/kishlaykiku/Kishlay-JA211.git
   cd cricbrik/frontend
   ```
2. Install dependencies:
   ```console
   npm install
   ```
3. Start the development server:
   ```console
   ng serve
   ```
4. Open your browser and navigate to ```http://localhost:4200/```.

## Usage

- **Navigating**: Use the navbar to switch between the Player List and Add Player pages.
- **Searching**: Enter a team name in the search bar and press "Search" to find players.
- **Adding Players**: Fill out the form on the "Add Player" page and submit it.
- **Backend API**: The backend provides RESTful API endpoints for managing player data.
