package Game;

import DataHandler.DataManager;
import Game.PopUpMessage.QueryToBuyPlot;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;

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
    ArrayList<HashMap<String,Label>> playerFXLabels = new ArrayList<>();

    @FXML private Group plots;

    @FXML
    private void rollDiceAction(Event event) {
        if (theGame.players.get(theGame.turnOrder).boardPosition == 0) {
            //Make jail actions. Break and Return functions to break method.
        } else {
            theGame.throwDiceToMove(theGame.players.get(theGame.turnOrder));
        }
        updatePlayerTokens();
        resolvePlayerPlacement();
        updatePlayerStatistics();
        if (theGame.die1.result == theGame.die2.result) {
            theGame.throwDiceToMove(theGame.players.get(theGame.turnOrder));
            updatePlayerTokens();
            resolvePlayerPlacement();
            updatePlayerStatistics();
            //Take an extra turn.
            if (theGame.die1.result == theGame.die2.result) {
                theGame.throwDiceToMove(theGame.players.get(theGame.turnOrder));
                updatePlayerTokens();
                resolvePlayerPlacement();
                updatePlayerStatistics();
                if (theGame.die1.result == theGame.die2.result) {
                    //Go to jail, you criminal, think of the dice!
                    theGame.players.get(theGame.turnOrder).boardPosition = 0;
                    updatePlayerTokens();
                } else {
                    //Take another extra turn.
                    updatePlayerTokens();
                    resolvePlayerPlacement();
                    updatePlayerStatistics();
                }
            }
        }
        //Check for bankruptcy and game objectives.
        theGame.endTurn();
    }

    private void resolvePlayerPlacement() {
        if (theGame.board.plotsOnBoard.get((theGame.players.get(theGame.turnOrder).boardPosition)).event != null) {
            //Do event stuff.
        } else if (theGame.board.ownerships.get(theGame.players.get(theGame.turnOrder).boardPosition) == null) {
            //Do buy property stuff.
            QueryToBuyPlot query = new QueryToBuyPlot
                    (theGame.board.plotsOnBoard.get(theGame.players.get(theGame.turnOrder).boardPosition),
                            theGame.players.get(theGame.turnOrder),theGame.board.ownerships);
        } else {
            //Do payment stuff.
        }
    }

    @FXML
    private void SaveGameAction (Event event) {
        DataManager dataManager = new DataManager("saveFiles/test");
        dataManager.saveGameObjectToFile(this.theGame);
    }

    public void updatePlayerTokens() {
        playerTokens.getChildren().get(theGame.turnOrder).setLayoutY(plots.getChildren().get(theGame.players.
                get(theGame.turnOrder).boardPosition).getLayoutY()+(10+(8*theGame.turnOrder)));
        playerTokens.getChildren().get(theGame.turnOrder).setLayoutX(plots.getChildren().get(theGame.players.
                get(theGame.turnOrder).boardPosition).getLayoutX()+10);
    }

    public void updateAllPlayerTokens() {
        for (int i = 0; i < theGame.players.size(); i++) {
            playerTokens.getChildren().get(i).setLayoutY(plots.getChildren().get(theGame.players.get(i).boardPosition).
                    getLayoutY()+(10+(8*i)));
            playerTokens.getChildren().get(i).setLayoutX(plots.getChildren().get(theGame.players.get(i).boardPosition).
                    getLayoutX()+10);
        }
    }

    public void updatePlayerStatistics() {
        for (int i = 0; i < theGame.players.size(); i++) {
            playerFXLabels.get(i).get("Name").setText(theGame.players.get(i).name);
            playerFXLabels.get(i).get("Wealth").setText(theGame.players.get(i).wealth + ",-");
            playerFXLabels.get(i).get("Placement").setText("Placement: " + theGame.players.get(i).boardPosition);
        }
    }

    public void setupBoard() {
        for (int i =0; i < plots.getChildren().size(); i++) {
            Node nodeRectangle = plots.getChildren().get(i);
            if (nodeRectangle instanceof Rectangle && theGame.board.plotsOnBoard.get(i).district != null) {
                Stop[] stops = new Stop[] {new Stop(0, Color.BLACK),
                        new Stop(1, Color.valueOf(theGame.board.plotsOnBoard.get(i).district))};
                LinearGradient linearGradient = new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE, stops);
                ((Rectangle) nodeRectangle).setFill(linearGradient);
            }
        }
    }

    public void setupPlayers() {
        for (int i = 0; i < theGame.players.size(); i++) {
            playerFXLabels.add(new HashMap<>());
        }
        playerFXLabels.get(0).put("Name", playerName1);
        playerFXLabels.get(0).put("Wealth",playerWealth1);
        playerFXLabels.get(0).put("Placement",playerPosition1);
        playerFXLabels.get(1).put("Name",playerName2);
        playerFXLabels.get(1).put("Wealth",playerWealth2);
        playerFXLabels.get(1).put("Placement",playerPosition2);
        playerFXLabels.get(2).put("Name",playerName3);
        playerFXLabels.get(2).put("Wealth",playerWealth3);
        playerFXLabels.get(2).put("Placement",playerPosition3);
        if (theGame.players.size() > 3) {
            playerFXLabels.get(3).put("Name",playerName4);
            playerFXLabels.get(3).put("Wealth",playerWealth4);
            playerFXLabels.get(3).put("Placement",playerPosition4);
            if (theGame.players.size() > 4) {
                playerFXLabels.get(4).put("Name",playerName5);
                playerFXLabels.get(4).put("Wealth",playerWealth5);
                playerFXLabels.get(4).put("Placement",playerPosition5);
                if (theGame.players.size() > 5) {
                    playerFXLabels.get(5).put("Name",playerName6);
                    playerFXLabels.get(5).put("Wealth",playerWealth6);
                    playerFXLabels.get(5).put("Placement",playerPosition6);
                } else {
                    playerName6.setVisible(false);
                    playerWealth6.setVisible(false);
                    playerPosition6.setVisible(false);
                    playerTokens.getChildren().get(5).setVisible(false);
                }
            } else {
                playerName5.setVisible(false);
                playerWealth5.setVisible(false);
                playerPosition5.setVisible(false);
                playerTokens.getChildren().get(4).setVisible(false);
                playerName6.setVisible(false);
                playerWealth6.setVisible(false);
                playerPosition6.setVisible(false);
                playerTokens.getChildren().get(5).setVisible(false);
            }
        } else {
            playerName4.setVisible(false);
            playerWealth4.setVisible(false);
            playerPosition4.setVisible(false);
            playerTokens.getChildren().get(3).setVisible(false);
            playerName5.setVisible(false);
            playerWealth5.setVisible(false);
            playerPosition5.setVisible(false);
            playerTokens.getChildren().get(4).setVisible(false);
            playerName6.setVisible(false);
            playerWealth6.setVisible(false);
            playerPosition6.setVisible(false);
            playerTokens.getChildren().get(5).setVisible(false);
        }
    }
}
