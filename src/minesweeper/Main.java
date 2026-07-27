package minesweeper;

// Application entry point

public class Main {
    public static void main(String[] args) {
        // Initializes a 10x10 board with 10 mines
        Minesweeper game = new Minesweeper(10, 10);
        game.start();
    }
}