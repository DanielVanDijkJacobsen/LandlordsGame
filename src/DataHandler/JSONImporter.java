package DataHandler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

//Følger denne guide https://howtodoinjava.com/library/json-simple-read-write-json-examples/

public class JSONImporter {
    JSONParser parser = new JSONParser();
    FileReader reader;
    {
        try {
            reader = new FileReader("DataHandler/package.json");
            Object object = parser.parse(reader);
            JSONArray listOfPlots = (JSONArray) object;
            System.out.println(listOfPlots);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

}
