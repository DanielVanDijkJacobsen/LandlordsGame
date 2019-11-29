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

    @FXML private Circle playerToken1; @FXML private Circle playerToken2; @FXML private Circle playerToken3;
    @FXML private Circle playerToken4; @FXML private Circle playerToken5; @FXML private Circle playerToken6;

    @FXML private Group plots;

    @FXML
    private void rollDiceAction(Event event) {
        theGame.throwDiceToMove(theGame.players.get(0));
        if (theGame.players.get(0).boardPosition > 40) {
            theGame.players.get(0).boardPosition = theGame.players.get(0).boardPosition -40;
        }
        playerToken1.setLayoutY(plots.getChildren().get(theGame.players.get(0).boardPosition).getLayoutY());
        playerToken1.setLayoutX(plots.getChildren().get(theGame.players.get(0).boardPosition).getLayoutX());
    }
}
