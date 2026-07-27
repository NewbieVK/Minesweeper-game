package minesweeper;

//Encapsulates the state and behavior of an individual grid cell

public class Cell {
    private boolean isMine;
    private boolean isRevealed;
    private int neighborMines;

    public Cell() {
        this.isMine = false;
        this.isRevealed = false;
        this.neighborMines = 0;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public int getNeighborMines() {
        return neighborMines;
    }

    public void setNeighborMines(int count) {
        this.neighborMines = count;
    }
}
