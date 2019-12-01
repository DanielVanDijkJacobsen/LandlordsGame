package Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class GameMaster implements Serializable {
    public ArrayList<Player> players;
    public Board board;
    int roundsLeft;
    String boardType;
    boolean auctionIfNotBought;
    boolean fastStart;
    boolean endOnBankruptcy;
    boolean endOnOverwhelmingWealth;
    boolean differingInheritance;
    public boolean randomizeTurnOrder;
    public int turnOrder;
    Die die1;
    Die die2;

    public GameMaster(int roundsLeft, String boardType, boolean auctionIfNotBought,
                      boolean fastStart, boolean endOnBankruptcy, boolean endOnOverwhelmingWealth,
                      boolean differingInheritance, boolean randomizeTurnOrder) {
        this.players = new ArrayList<>();
        this.roundsLeft = roundsLeft;
        this.boardType = boardType;
        this.auctionIfNotBought = auctionIfNotBought;
        this.fastStart = fastStart;
        this.endOnBankruptcy = endOnBankruptcy;
        this.endOnOverwhelmingWealth = endOnOverwhelmingWealth;
        this.differingInheritance = differingInheritance;
        this.randomizeTurnOrder = randomizeTurnOrder;
        this.turnOrder = 0;
        this.die1 = new Die(6);
        this.die2 = new Die(6);
    }

    public void randomizeTurnOrder() {
        Collections.shuffle(this.players);
    }

    public void endTurn() {
        this.turnOrder++;
        if (this.turnOrder == this.players.size()) {
            this.turnOrder = 0;
        }
    }

    public void assignOwnershipOfPlot(int plotID, int playerID) {
        this.board.ownerships.remove(plotID);
        this.board.ownerships.put(plotID,playerID);
    }

    public int determineOwnershipOfPlot(int plotID) {
        return this.board.ownerships.get(plotID);
    }

    public void throwDiceToMove(Player playerToMove) {
        this.die1.roll(); this.die2.roll();
        playerToMove.boardPosition = playerToMove.boardPosition + this.die1.result + this.die2.result;
    }
}
