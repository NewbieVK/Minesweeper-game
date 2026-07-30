package minesweeper;

// Controls game state, manages user moves, and enforces win/loss conditions

import java.util.Scanner;

public class Minesweeper {
    private final Board board;
    private boolean gameOver;
    private boolean gameWon;
    private int revealedSafeCount;

    public Minesweeper(int gridSize, int mineCount) {
        this.board = new Board(gridSize, mineCount);
        this.gameOver = false;
        this.gameWon = false;
        this.revealedSafeCount = 0;
    }

public void start() {
    try (Scanner scanner = new Scanner(System.in)) {

        System.out.println("=================================");
        System.out.println("   WELCOME TO JAVA MINESWEEPER   ");
        System.out.println("=================================");

        while (!gameOver) {
            board.render();
            System.out.print("Enter move (row col, e.g., '3 5'): ");

            // Read the entire line typed by the user
            String input = scanner.nextLine().trim();

            // Split the input by whitespace
            String[] parts = input.split("\\s+");

            if (parts.length >= 2) {
                try {
                    int row = Integer.parseInt(parts[0]);
                    int col = Integer.parseInt(parts[1]);
                    makeMove(row, col);
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Invalid input! Please enter valid integers (e.g., '3 5').");
                }
            } else {
                System.out.println("⚠️ Invalid input! Please enter TWO numbers separated by a space.");
            }
        }

        handleGameEnd();
    }
}

    private void makeMove(int row, int col) {
        if (!board.isValidCoordinate(row, col)) {
            System.out.println("⚠️ Invalid coordinates! Use values from 0 to " + (board.getSize() - 1) + ".");
            return;
        }

        Cell cell = board.getCell(row, col);

        if (cell.isRevealed()) {
            System.out.println("⚠️ Cell already revealed! Pick a different spot.");
            return;
        }

        cell.setRevealed(true);

        if (cell.isMine()) {
            gameOver = true;
            return;
        }

        revealedSafeCount++;
        int totalSafeCells = (board.getSize() * board.getSize()) - board.getTotalMines();

        if (revealedSafeCount == totalSafeCells) {
            gameWon = true;
            gameOver = true;
        }
    }

    private void handleGameEnd() {
        if (gameWon) {
            board.render();
            System.out.println("🎉 Congratulations! You revealed all safe squares. You win!");
        } else {
            board.revealAllMines();
            board.render();
            System.out.println("💥 BOOM! You hit a mine. Game Over!");
        }
    }
}