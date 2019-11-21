package Game;

import java.io.Serializable;
import java.util.ArrayList;

public class GameMaster implements Serializable {
    public ArrayList<Player> players;
    int roundsLeft;
    String boardType;
    boolean auctionIfNotBought;
    boolean fastStart;
    boolean endOnBankruptcy;
    boolean endOnOverwhelmingWealth;
    boolean differingInheritance;
    boolean randomizeTurnOrder;

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
    }
}
