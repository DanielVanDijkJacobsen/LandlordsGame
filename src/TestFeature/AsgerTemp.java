package TestFeature;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class AsgerTemp {


    Stage window;
    Scene scene1, scene2;

    //@Override
    public void confirmationDialog(Stage primaryStage) throws Exception {
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


    //@Override
    public void payDialog(Stage primaryStage) throws Exception {
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Payment Alert");
        alert1.setHeaderText("You have landed on a property, pay up!"); //evt indsæt beløb der skal betales

        Optional<ButtonType> result = alert1.showAndWait();
        if (result.get() == ButtonType.OK) {

        } else {

        }

    }

    //@Override
    public void lostDialog(Stage primaryStage) throws Exception {
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("Information Alert");
        alert2.setHeaderText("You have lost" );
        alert2.setContentText("Better luck next time =)");

        Optional<ButtonType> result = alert2.showAndWait();
        if(result.get() == ButtonType.OK) {

        } else {
        }
    }
    //@Override
    public void chanceDialog(Stage primaryStage) throws Exception {
        Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
        alert3.setTitle("You have landed on a chance card!");
        alert3.setHeaderText(""); //mulighed for at inserte chance card text her

        Optional<ButtonType> result = alert3.showAndWait();
        if (result.get() == ButtonType.OK) {
        } else {
        }
    }
}