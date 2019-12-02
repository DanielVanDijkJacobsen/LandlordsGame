package Game;

import Game.Plots.Plot;
import javafx.scene.control.Label;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Player implements Serializable {
    String name;
    int ID;
    public int wealth;
    public int value;
    public int boardPosition;
    public HashMap<String,Label> javaFXlabels = new HashMap<>();

    public Player(String name, int ID) {
        this.name = name;
        this.boardPosition = 1;
        this.wealth = 30000;
        this.ID = ID;
    }
}
