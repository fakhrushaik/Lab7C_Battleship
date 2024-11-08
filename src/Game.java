public class Game {
    private Board board;
    private GUI gui;
    private Counter counter;

    public Game() {
        this.board = new Board();
        this.gui = new GUI(this, board);
        this.counter = new Counter();
    }

    public void start() {
        board.initialize();
        gui.display();
    }

    public void handlePlayerAction(int x, int y) {
        boolean isHit = board.fireMissile(x, y);
        if (isHit) {
            counter.incrementHit();
            gui.updateHitCounter(counter.getTotalHits());
        } else {
            counter.incrementMiss();
            gui.updateMissCounter(counter.getTotalMisses());
            if (counter.getMissCounter() >= 5) {
                counter.incrementStrike();
                counter.resetMissCounter();
                gui.updateStrikeCounter(counter.getStrikes());
            }
        }
        if (board.areAllShipsSunk()) {
            gui.showWinMessage();
        } else if (counter.getStrikes() >= 3) {
            gui.showLoseMessage();
        }
    }
}
