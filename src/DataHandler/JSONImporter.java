package DataHandler;

import Game.Board;
import Game.Plots.Plot;
import Game.Plots.Train;
import Game.Plots.Utility;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

//Følger denne guide https://howtodoinjava.com/library/json-simple-read-write-json-examples/

public class JSONImporter {
    JSONParser parser = new JSONParser();
    FileReader reader;

    public Board createBoardJSON(String boardName) {
        ArrayList <Plot> plotsForBoard = new ArrayList<>();
        try {
            reader = new FileReader("package.json");
            Object object = parser.parse(reader);
            Plot plot;
            JSONObject initialFile = (JSONObject) object;
            JSONObject boardObject = (JSONObject) initialFile.get("plots");
            JSONArray arrayOfPlots = (JSONArray) boardObject.get(boardName);
            for (int i = 0; i < arrayOfPlots.size(); i++) {
                JSONObject plotJSONObject = (JSONObject) arrayOfPlots.get(i);
                int plotID = Integer.parseInt(plotJSONObject.get("ID").toString());
                if (plotJSONObject.size() == 2) {
                    if (plotJSONObject.get("EVENT") == null) {
                        if (plotJSONObject.get("TRAIN") != null) {
                            plot = new Train(plotID,plotJSONObject.get("TRAIN").toString());
                        } else if (plotJSONObject.get("UTILITY") != null) {
                            plot = new Utility(plotID,plotJSONObject.get("UTILITY").toString());
                        } else {
                            plot = new Plot(plotID);
                        }
                    } else {
                        plot = new Plot(plotID,plotJSONObject.get("EVENT").toString());
                    }
                } else if (plotJSONObject.size() == 10) {
                    plot = new Plot(plotID, plotJSONObject.get("TITLE").toString(),
                            Integer.parseInt(plotJSONObject.get("PRICE").toString()),
                            Integer.parseInt(plotJSONObject.get("RENT").toString()),
                            Integer.parseInt(plotJSONObject.get("U1").toString()),
                            Integer.parseInt(plotJSONObject.get("U2").toString()),
                            Integer.parseInt(plotJSONObject.get("U3").toString()),
                            Integer.parseInt(plotJSONObject.get("U4").toString()),
                            Integer.parseInt(plotJSONObject.get("U5").toString()),
                            plotJSONObject.get("DISTRICT").toString());
                } else {
                    plot = new Plot(plotID);
                }
                plotsForBoard.add(plot);
            }
        } catch (ParseException | IOException e) {
                e.printStackTrace();
        }
        Board board = new Board();
        board.plotsOnBoard.addAll(plotsForBoard);
        return board;
    }

}
