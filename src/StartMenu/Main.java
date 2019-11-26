package StartMenu;

import DataHandler.JSONImporter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage stage) throws Exception {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("start.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("The Landlord's Game");
        stage.show();
    }

    public static void main(String[] args){
        JSONImporter jsonImporter = new JSONImporter();
        jsonImporter.createPlotsFromJSON("Matador");
        launch(args);

    }
}
