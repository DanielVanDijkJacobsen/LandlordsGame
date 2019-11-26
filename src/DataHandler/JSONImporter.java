package DataHandler;

import Game.Plots.Plot;
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
    public ArrayList<Plot> createPlotsFromJSON(String boardName) {
        ArrayList <Plot> plotsForBoard = new ArrayList<>();
        {
            try {
                reader = new FileReader("package.json");
                Object object = parser.parse(reader);
                JSONObject initialFile = (JSONObject) object;
                JSONObject boardObject = (JSONObject) initialFile.get("plots");
                JSONArray arrayOfPlots = (JSONArray) boardObject.get(boardName);
                for (int i = 0; i < arrayOfPlots.size(); i++) {
                    JSONObject plotJSONObject = (JSONObject) arrayOfPlots.get(i);
                    int plotID = Integer.parseInt(plotJSONObject.get("ID").toString());
                    Plot plot = new Plot(plotID);
                    plotsForBoard.add(plot);
                }
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        }
        return plotsForBoard;
    }

}
