package Game;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;

public class GUI {
    public GameMaster theGame;

    @FXML private Button rollDice;

    @FXML private Group playerTokens;

    @FXML private Group plots;

    @FXML
    private void rollDiceAction(Event event) {
        theGame.throwDiceToMove(theGame.players.get(theGame.turnOrder));
        System.out.println(theGame.turnOrder + " " + theGame.players.get(theGame.turnOrder).boardPosition);
        if (theGame.players.get(theGame.turnOrder).boardPosition > 40) {
            theGame.players.get(theGame.turnOrder).boardPosition = theGame.players.get(theGame.turnOrder).boardPosition -40;
        }
        playerTokens.getChildren().get(theGame.turnOrder).setLayoutY(plots.getChildren().get(theGame.players.get(theGame.turnOrder).boardPosition).getLayoutY());
        playerTokens.getChildren().get(theGame.turnOrder).setLayoutX(plots.getChildren().get(theGame.players.get(theGame.turnOrder).boardPosition).getLayoutX());
        theGame.endTurn();
    }
}
