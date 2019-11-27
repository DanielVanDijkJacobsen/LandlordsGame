package Game;

import Game.Plots.Plot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Board implements Serializable {
    public ArrayList<Plot> plotsOnBoard = new ArrayList<>();
    public HashMap<Integer, Integer> ownerships = new HashMap<>();

}
