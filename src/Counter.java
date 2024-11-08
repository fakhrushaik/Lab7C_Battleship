public class Counter {
    private int missCounter;
    private int strikeCounter;
    private int totalMisses;
    private int totalHits;

    public Counter() {
        this.missCounter = 0;
        this.strikeCounter = 0;
        this.totalMisses = 0;
        this.totalHits = 0;
    }

    public void incrementMiss() {
        missCounter++;
        totalMisses++;
    }

    public void resetMissCounter() {
        missCounter = 0;
    }

    public void incrementStrike() {
        strikeCounter++;
    }

    public void incrementHit() {
        totalHits++;
    }

    public int getMissCounter() {
        return missCounter;
    }

    public int getStrikes() {
        return strikeCounter;
    }

    public int getTotalMisses() {
        return totalMisses;
    }

    public int getTotalHits() {
        return totalHits;
    }
}
