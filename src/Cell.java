public class Cell {
    private Ship ship;
    private boolean hit;
    private boolean miss;

    public Cell() {
        this.ship = null;
        this.hit = false;
        this.miss = false;
    }

    public boolean isBlank() {
        return ship == null && !hit && !miss;
    }

    public boolean hasShip() {
        return ship != null;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void hit() {
        if (ship != null) {
            ship.hit();
            hit = true;
        }
    }

    public void setMiss() {
        miss = true;
    }
}
