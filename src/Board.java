import java.util.Random;

public class Board {
    private final int SIZE = 10;
    private Cell[][] cells;
    private Ship[] ships;

    public Board() {
        cells = new Cell[SIZE][SIZE];
        ships = new Ship[]{new Ship(5), new Ship(4), new Ship(3), new Ship(3), new Ship(2)};
    }

    public void initialize() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }
        placeShips();
    }

    private void placeShips() {
        Random rand = new Random();
        for (Ship ship : ships) {
            boolean placed = false;
            while (!placed) {
                int x = rand.nextInt(SIZE);
                int y = rand.nextInt(SIZE);
                boolean horizontal = rand.nextBoolean();
                placed = placeShip(ship, x, y, horizontal);
            }
        }
    }

    private boolean placeShip(Ship ship, int x, int y, boolean horizontal) {
        int length = ship.getLength();
        if (horizontal) {
            if (x + length > SIZE) return false;
            for (int i = x; i < x + length; i++) {
                if (!cells[i][y].isBlank()) return false;
            }
            for (int i = x; i < x + length; i++) {
                cells[i][y].setShip(ship);
            }
        } else {
            if (y + length > SIZE) return false;
            for (int i = y; i < y + length; i++) {
                if (!cells[x][i].isBlank()) return false;
            }
            for (int i = y; i < y + length; i++) {
                cells[x][i].setShip(ship);
            }
        }
        return true;
    }

    public boolean fireMissile(int x, int y) {
        if (cells[x][y].isBlank()) {
            cells[x][y].setMiss();
            return false;
        } else if (cells[x][y].hasShip()) {
            cells[x][y].hit();
            return true;
        }
        return false;
    }

    public boolean areAllShipsSunk() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) return false;
        }
        return true;
    }
}
