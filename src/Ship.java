public class Ship {
    private int length;
    private int hitCount;

    public Ship(int length) {
        this.length = length;
        this.hitCount = 0;
    }

    public int getLength() {
        return length;
    }

    public void hit() {
        hitCount++;
    }

    public boolean isSunk() {
        return hitCount == length;
    }
}
