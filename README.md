# 💣 Java Console Minesweeper 🚩

> _A lightweight, retro terminal-based implementation of the classic Minesweeper game, built in pure Java._

---

## 🎮 Previews

  <img src="./src/asset/minesweeper.png" width=50%>
  <img src="./src/asset/Winning page.png" width=60%>

## Prerequisites

- Java Development Kit (JDK) version 8 or higher installed on your system.
- A terminal or command prompt window.

## How to play

### Objective: Reveal all non-mine safe cells on the grid without triggering a mine.

### Game Rules

- The Grid: The board is a $10 \times 10$ grid containing 10 hidden mines.

- Symbols:. represents an unrevealed cell.0–8 represents a safe cell and indicates how many mines surround it in the 8 adjacent squares.\* represents a revealed mine.

- Player Moves: Enter coordinates using row and column numbers (0 to 9) separated by a space.

### 🏆 Win / Loss Conditions

- 🎉 **Victory:** Successfully clear all **90 safe squares**.
- 💥 **Game Over:** Select a mine coordinate. The terminal outputs `"boom!"` and reveals all hidden mines

## 🚀 How to Run

1. Open your terminal in the **project root directory**.
2. Run the following command:

```bash
java -cp src minesweeper.Main


```
