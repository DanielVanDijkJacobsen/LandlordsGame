package TestFeature;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class AsgerTemp {


    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Button btn1 = new Button("LALALA");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Alert");
        alert.setHeaderText("Do you wish to buy this property?");
        alert.setContentText("Are you sure?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // user picks okay
        } else {
            // user picks cancel
        }
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("new button test");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Button btn1 = new Button("LALALA");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Payment Alert");
        alert.setHeaderText("You have landed on a property, pay up!");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {  //skal kun have en ok knap, skal rettes til.
            // user picks okay
        } else {
            // user picks cancel
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        //Button btn1 = new Button("LALALA");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("You have lost! Goodbye!");
        alert.setHeaderText("Better luck next time!");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {    //skal kun have ok knap, mangler at modificeres
            // user picks okay
        } else {
            // user picks cancel
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        //Button btn1 = new Button("LALALA");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("You have landed on a chance card!");
        alert.setHeaderText(""); //mulighed for at inserte chance card text her

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {   //skal finde på en anden mulighed her da user ikke skal trykke cancel på chancecards
            // user picks okay
        } else {
            // user picks cancel
        }
    }
}