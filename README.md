# Minecraft Rank Management API - README

## Description
This Minecraft API has been developed to manage player ranks without relying on existing plugins. It handles permissions, role display on the scoreboard, and role display in join and leave messages. There is a `setrank` command that uses numbers to assign roles to players. All modifications made to players are not immediately sent to the database to avoid excessive requests; instead, a map is used to store changes temporarily.

## Features

- **Permission Management** : Manage player permissions based on their ranks.
- **Scoreboard Role Display** : Display player roles on the in-game scoreboard.
- **Join/Leave Message Role Display** : Show player roles in the join and leave messages.
- **Command `setrank`** : Assign roles to players using numerical identifiers.
- **Temporary Storage** : Uses a map to temporarily store player changes before sending them to the database, reducing the number of database requests.

## Usage

1. Ensure you have the necessary permissions to use the API.
2. Use the `setrank` command to assign roles to players:
   ```
   /setrank [player] [role_number]
   ```
3. The API will manage permissions, scoreboard displays, and join/leave messages automatically based on the player's rank.

## Project Status

This API is not completely finished. Initially intended for a Minecraft project, development has been paused due to time constraints. However, the basic features listed above are operational and can be used.
