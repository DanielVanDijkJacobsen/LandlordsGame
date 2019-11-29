package Game;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GUI {
    public GameMaster theGame;

    @FXML private Button rollDice;

    @FXML private Group playerTokens;
    @FXML private Label playerName1; @FXML private Label playerWealth1; @FXML private Label playerPosition1;
    @FXML private Label playerName2; @FXML private Label playerWealth2; @FXML private Label playerPosition2;
    @FXML private Label playerName3; @FXML private Label playerWealth3; @FXML private Label playerPosition3;
    @FXML private Label playerName4; @FXML private Label playerWealth4; @FXML private Label playerPosition4;
    @FXML private Label playerName5; @FXML private Label playerWealth5; @FXML private Label playerPosition5;
    @FXML private Label playerName6; @FXML private Label playerWealth6; @FXML private Label playerPosition6;

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
        updatePlayerStatistics();
        theGame.endTurn();
    }

    private void updatePlayerStatistics() {
        this.playerName1.setText(theGame.players.get(0).name);
        this.playerName2.setText(theGame.players.get(1).name);
        this.playerName3.setText(theGame.players.get(2).name);
        this.playerName4.setText(theGame.players.get(3).name);
        this.playerName5.setText(theGame.players.get(4).name);
        this.playerName6.setText(theGame.players.get(5).name);
        this.playerWealth1.setText(theGame.players.get(0).wealth + ",-");
        this.playerWealth2.setText(theGame.players.get(1).wealth + ",-");
        this.playerWealth3.setText(theGame.players.get(2).wealth + ",-");
        this.playerWealth4.setText(theGame.players.get(3).wealth + ",-");
        this.playerWealth5.setText(theGame.players.get(4).wealth + ",-");
        this.playerWealth6.setText(theGame.players.get(5).wealth + ",-");
        this.playerPosition1.setText("Placement: " + theGame.players.get(0).boardPosition);
        this.playerPosition2.setText("Placement: " + theGame.players.get(1).boardPosition);
        this.playerPosition3.setText("Placement: " + theGame.players.get(2).boardPosition);
        this.playerPosition4.setText("Placement: " + theGame.players.get(3).boardPosition);
        this.playerPosition5.setText("Placement: " + theGame.players.get(4).boardPosition);
        this.playerPosition6.setText("Placement: " + theGame.players.get(5).boardPosition);
    }
}
