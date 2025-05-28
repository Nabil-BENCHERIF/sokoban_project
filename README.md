

# Sokoban Game in Java

This project is a Java implementation of the classic Sokoban puzzle game. It models the game environment and includes a solver to automatically solve Sokoban levels.

## Overview

Sokoban is a puzzle game created in Japan in the early 1980s. The player controls a warehouse keeper who must push boxes onto target locations within a grid-like warehouse layout. The game challenges logical thinking and planning, as boxes cannot be pulled or moved through walls.

## Features

- **Game Modeling:**  
  - The game board is represented by a 2D grid containing walls, empty spaces, target cells, boxes, and the player.  
  - Static elements (walls, empty spaces, targets) and dynamic elements (player, boxes) are modeled separately to optimize memory and processing.

- **Movement Rules:**  
  - The player can move up, down, left, and right.  
  - The player can only push one box at a time if the destination cell is free.  
  - The player cannot pull boxes or jump over obstacles.

- **Solver:**  
  - A naive solver that plays random moves.  
  - An improved solver that uses Dijkstra’s algorithm to find reachable positions and only makes moves that push boxes.  
  - A bonus solver that uses heuristics to avoid unsolvable configurations and prevent revisiting already tested states.

## Project Structure

- **Core Classes:**  
  - `Element` (base class), `Immobile`, `Mobile`, `Mur` (wall), `Case` (empty space), `Caisse` (box), `Joueur` (player)  
  - `Niveau` (static game level with grid and target positions)  
  - `Configuration` (dynamic game state including player and boxes)  
  - `Position` and `Direction` classes for managing coordinates and movements

- **Solver Classes:**  
  - `SolverInterface` defines the solver behavior  
  - `Solver` implements different solving strategies

- **UI Classes:**  
  - `SimpleInterface`, `SokobanUI` for game display and interaction

## How to Run

1. Compile all Java files using your favorite IDE or the command line.  
2. Run the main class `Sokoban` to start the game.  
3. Load levels from the provided `.txt` files (e.g., `microban.txt`) to play or solve them.

## Usage

- Use arrow keys or on-screen controls to move the player.  
- The goal is to push all boxes onto the target cells.  
- The game ends when all boxes are correctly placed.

## License

This project is open-source under the terms specified in `LICENSE.txt`.
```
