package Game;

import java.io.Serializable;

public class Player implements Serializable {
    String name;
    int ID;
    public int wealth;
    public int value;
    public int boardPosition;

    public Player(String name, int ID) {
        this.name = name;
        this.boardPosition = 1;
        this.wealth = 30000;
        this.ID = ID;
    }
}
