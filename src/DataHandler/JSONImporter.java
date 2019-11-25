package DataHandler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONImporter {
    JSONParser parser = new JSONParser();

    try (FileReader reader = new FileReader("DataHandler/package.json")) {
        Object object = parser.parse(reader);

        JSONArray plots = (JSONArray) object;
        for (int i = 0; i < plots.size(); i++) {

        }
    }
}
