package TestFeature;

import Game.GameMaster;
import Game.Player;
import Game.Plots.Plot;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Optional;

public class AsgerTemp {

    public GameMaster theGame;

    public void jailFunctions(Stage primaryStage) throws Exception {
        Label label;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Get out of jail options");
        alert.setHeaderText("Choose options for how to get out of jail");
        alert.setContentText("I hope we don't see you in here again!");

        Player player = theGame.players.get(theGame.turnOrder);
        Plot plot = theGame.board.plotsOnBoard.get(player.boardPosition);
        HashMap<Integer, Integer> ownerships = theGame.board.ownerships;

        ButtonType jailRollDice = new ButtonType("Roll dice");
        ButtonType getOutToken = new ButtonType("Use token");
        ButtonType payOption = new ButtonType("Pay 1000");

        alert.getButtonTypes().clear();

        alert.getButtonTypes().addAll(jailRollDice, getOutToken, payOption);

        Optional<ButtonType> result = alert.showAndWait();
        if (payOption.getText() == "pay 1000") {
            player.wealth = player.wealth - 1000;
            theGame.throwDiceToMove(theGame.players.get(theGame.turnOrder));
            //make the user pay 1000 from player.wealth
        } else if (jailRollDice.getText() == "Roll dice") {
            for (int i = 0; i < 3; i++) {
                theGame.die1.roll();
                theGame.die2.roll();
                if (theGame.die1.result == theGame.die2.result) {
                    theGame.players.get(theGame.turnOrder).boardPosition = 11 + theGame.die1.result + theGame.die2.result;
                    break;
                }
            }
        } else {
            theGame.endTurn();
        }

    }
}



/*






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
        */