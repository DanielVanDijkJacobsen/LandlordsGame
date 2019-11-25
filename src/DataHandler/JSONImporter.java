package DataHandler;

import Game.Plots.Plot;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Følger denne guide https://howtodoinjava.com/library/json-simple-read-write-json-examples/

public class JSONImporter {
    JSONParser parser = new JSONParser();
    FileReader reader;
    public ArrayList<Plot> createPlotsFromJSON() {
        ArrayList <Plot> plotsForBoard = null;
        {
            try {
                reader = new FileReader("DataHandler/package.json");
                Object object = parser.parse(reader);
                JSONArray listOfPlots = (JSONArray) object;
                System.out.println(listOfPlots);
                listOfPlots.forEach(plot -> createPlot((JSONObject) plot, plotsForBoard));
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        }
        return plotsForBoard;
    }

    private void createPlot(JSONObject plotJSON, ArrayList<Plot> plotsForBoard) {
        JSONObject plotObject = (JSONObject) plotJSON.get("plotsMatador");
        String plotID = (String) plotJSON.get("ID");
        System.out.println(plotID); //Checks to see what plot is used.
    }
}
