package minesweeper;

//Manages grid generation, mine placement, adjacent calculations, and board rendering

import java.util.Random;

public class Board {
    private final int size;
    private final int totalMines;
    private final Cell[][] grid;

    public Board(int size, int totalMines) {
        this.size = size;
        this.totalMines = totalMines;
        this.grid = new Cell[size][size];

        initializeGrid();
        placeMines();
        calculateNeighborCounts();
    }

    private void initializeGrid() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                grid[r][c] = new Cell();
            }
        }
    }

    private void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;

        while (minesPlaced < totalMines) {
            int r = random.nextInt(size);
            int c = random.nextInt(size);

            if (!grid[r][c].isMine()) {
                grid[r][c].setMine(true);
                minesPlaced++;
            }
        }
    }

    private void calculateNeighborCounts() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (grid[r][c].isMine()) continue;

                int count = 0;
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        int nr = r + dr;
                        int nc = c + dc;

                        if (isValidCoordinate(nr, nc) && grid[nr][nc].isMine()) {
                            count++;
                        }
                    }
                }
                grid[r][c].setNeighborMines(count);
            }
        }
    }

    public void render() {
        System.out.println("\n   0 1 2 3 4 5 6 7 8 9");
        System.out.println("  --------------------");

        for (int r = 0; r < size; r++) {
            System.out.print(r + "| ");
            for (int c = 0; c < size; c++) {
                Cell cell = grid[r][c];
                if (cell.isRevealed()) {
                    if (cell.isMine()) {
                        System.out.print("* ");
                    } else {
                        System.out.print(cell.getNeighborMines() + " ");
                    }
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void revealAllMines() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (grid[r][c].isMine()) {
                    grid[r][c].setRevealed(true);
                }
            }
        }
    }

    public boolean isValidCoordinate(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public int getSize() {
        return size;
    }

    public int getTotalMines() {
        return totalMines;
    }
}
