package Game;

import java.io.Serializable;

public class Player implements Serializable {
    public String name;
    public int ID;
    public int wealth;
    public int value;
    public int boardPosition;
    public int jailBreakTokens;

    public Player(String name, int ID) {
        this.name = name;
        this.boardPosition = 1;
        this.wealth = 30000;
        this.ID = ID;
        this.jailBreakTokens = 0;
    }
}
