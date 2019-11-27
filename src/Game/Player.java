package Game;

import Game.Plots.Plot;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    String name;
    int ID;
    public int wealth;
    public int value;
    public int boardPosition;
    public ArrayList<Plot> ownerships = new ArrayList<>();

    public Player(String name, int ID) {
        this.name = name;
        this.boardPosition = 1;
        this.wealth = 30000;
        this.ID = ID;
    }
}
